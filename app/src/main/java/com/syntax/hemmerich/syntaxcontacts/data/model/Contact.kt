package com.syntax.hemmerich.syntaxcontacts.data.model

data class Contact(var firstName:String, var lastName:String, var email:String, var number:String,var isFav:Boolean = false,var detailsShown:Boolean = false)

