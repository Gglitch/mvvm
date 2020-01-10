package com.ptechworld.mvvm.data.remote


data class RawText(
    var text: String? = null,
    var mode: String = "gfm",
    var context: String = "github/gollum"

)