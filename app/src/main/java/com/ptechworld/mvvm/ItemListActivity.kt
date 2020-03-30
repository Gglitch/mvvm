package com.ptechworld.mvvm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.dummy.DummyContent
import com.ptechworld.mvvm.view.itemlist.IssueListAdapter
import com.ptechworld.mvvm.view.itemlist.IssueSelectedListener
import com.ptechworld.mvvm.viewmodel.RepoViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*
import javax.inject.Inject


/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), IssueSelectedListener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModel: RepoViewModel? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[RepoViewModel::class.java]

        setSupportActionBar(toolbar)
        toolbar.title = title

        if (item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        val adapter = IssueListAdapter(this)
        item_list.adapter = adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: IssueListAdapter) {
        viewModel?.data?.observe(this, Observer {
            item_list.visibility = View.VISIBLE
            adapter.submitList(it.children)
        });

        viewModel?.loadError?.observe(this, Observer {isError: Boolean ->
            if (isError) {
                Snackbar.make(this.frameLayout, "An Error Occurred While Loading Data!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { viewModel?.load()}.show()
            }
        });
        viewModel?.loading?.observe(this, Observer {isLoading: Boolean ->
            if (isLoading) {
                loading.visibility = View.VISIBLE
                item_list.visibility = View.GONE
            } else {
                loading.visibility = View.GONE
            }
        })
        viewModel?.load()
    }

    override fun onSelect(issue: Issue) {
        if (twoPane) {
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ItemDetailFragment.ARG_ITEM_ID, issue.id)
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        } else {
            val intent = Intent(this, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailFragment.ARG_ITEM_ID, issue.id)
            }
            startActivity(intent)
        }
    }
}
