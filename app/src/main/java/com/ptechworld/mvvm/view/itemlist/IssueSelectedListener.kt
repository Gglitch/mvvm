package com.ptechworld.mvvm.view.itemlist

import com.ptechworld.mvvm.data.local.entity.Issue

interface IssueSelectedListener {
    fun onSelect(issue: Issue)
}