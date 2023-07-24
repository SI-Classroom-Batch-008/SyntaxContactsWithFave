package com.syntax.hemmerich.syntaxcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syntax.hemmerich.syntaxcontacts.adapter.ContactsAdapter
import com.syntax.hemmerich.syntaxcontacts.data.Datasource
import com.syntax.hemmerich.syntaxcontacts.databinding.ActivityMainBinding

/*
    TODO: Kommentar einfügen
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    /*
        TODO: Kommentar einfügen
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacts = Datasource().loadContacts()
        val recView = binding.recContacts
        recView.adapter = ContactsAdapter(this,contacts)
        recView.setHasFixedSize(true)

    }

    /*
        TODO: Kommentar einfügen
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
    /*
        TODO: Kommentar einfügen
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}