package com.syntax.hemmerich.syntaxcontacts.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syntax.hemmerich.syntaxcontacts.R
import com.syntax.hemmerich.syntaxcontacts.data.model.Contact
import com.syntax.hemmerich.syntaxcontacts.databinding.ContactItemBinding
import com.syntax.hemmerich.syntaxcontacts.databinding.FavItemBinding

/*
    TODO: Kommentar einfügen
 */
class ContactsAdapter(private val context: Context, private var dataSet: List<Contact>) :
    RecyclerView.Adapter<ViewHolder>() {

    /*
        TODO: Kommentar einfügen
     */
    private val FAVVIEWTYPE = 0
    private val CONTACTVIEWTYPE = 1

    /*
        TODO: Kommentar einfügen
     */
    class ContactViewHolder(val binding: ContactItemBinding) : ViewHolder(binding.root)
    class FavViewHolder(val binding: FavItemBinding) : ViewHolder(binding.root)


    /*
        TODO: Kommentar einfügen
     */
    override fun getItemViewType(position: Int): Int {
        if(dataSet[position].isFav){
            return FAVVIEWTYPE
        }else{
            return CONTACTVIEWTYPE
        }
    }

    /*
        TODO: Kommentar einfügen
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if(viewType == FAVVIEWTYPE){
            val binding = FavItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return FavViewHolder(binding)
        }else{
            val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ContactViewHolder(binding)
        }
    }

    /*
        TODO: Kommentar einfügen
     */
    override fun getItemCount(): Int {
        return dataSet.size
    }

    /*
        TODO: Kommentar einfügen
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var contact = dataSet[position]
        if(holder is ContactViewHolder){
        holder.binding.tvFirstName.text = contact.firstName
        holder.binding.tvLastName.text = contact.lastName
        holder.binding.tvEmail.text = contact.email
        holder.binding.tvNumber.text = contact.number

        if(contact.detailsShown){
            holder.binding.layoutDetails.visibility = VISIBLE
        }else{
            holder.binding.layoutDetails.visibility = GONE
        }
        holder.binding.btnFav.setOnClickListener {
            dataSet[position].isFav = !contact.isFav
            notifyItemChanged(position)
        }

        holder.binding.layoutInfo.setOnClickListener {
            dataSet[position].detailsShown = !contact.detailsShown
            notifyItemChanged(position)
        }
        }else if(holder is FavViewHolder){
            holder.binding.tvFirstName.text = contact.firstName
            holder.binding.tvLastName.text = contact.lastName
            holder.binding.tvEmail.text = contact.email
            holder.binding.tvNumber.text = contact.number

            if(contact.detailsShown){
                holder.binding.layoutDetails.visibility = VISIBLE
            }else{
                holder.binding.layoutDetails.visibility = GONE
            }
            holder.binding.btnFav.setOnClickListener {
                dataSet[position].isFav = !contact.isFav
                notifyItemChanged(position)
            }

            holder.binding.layoutInfo.setOnClickListener {
                dataSet[position].detailsShown = !contact.detailsShown
                notifyItemChanged(position)
            }
        }
    }
}