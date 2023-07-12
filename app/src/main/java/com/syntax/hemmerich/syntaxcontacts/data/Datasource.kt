package com.syntax.hemmerich.syntaxcontacts.data

import com.syntax.hemmerich.syntaxcontacts.data.model.Contact

class Datasource {
    fun loadContacts():List<Contact>{
        return listOf(
            Contact("Till","Hemmerich","Till@Syntax-institut.de","01112345", isAdmin = true),
            Contact("Jana","Jansen","Jana@Syntax-institut.de","023445124"),
            Contact("Lukas","Altmann","Lukas@Syntax-institut.de","05412345"),
            Contact("Ahmad","Alkhalaf","Ahmad@Syntax-institut.de","012305051"),
            Contact("Justus","FInke","Justus@Syntax-institut.de","0123590912", isAdmin = true),
            Contact("Noah","Diemel","Noah@Syntax-institut.de","03941202"),
            Contact("Pavel","Keßler","Pave.@Syntax-institut.de","04912942"),
            Contact("Talha","Taskaya","Talha@Syntax-institut.de","09552001")
        )
    }
}