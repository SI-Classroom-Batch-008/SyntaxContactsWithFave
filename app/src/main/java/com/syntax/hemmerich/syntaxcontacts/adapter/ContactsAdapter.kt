package com.syntax.hemmerich.syntaxcontacts.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syntax.hemmerich.syntaxcontacts.data.model.Contact
import com.syntax.hemmerich.syntaxcontacts.databinding.AdminItemBinding
import com.syntax.hemmerich.syntaxcontacts.databinding.ContactItemBinding

class ContactsAdapter(private val context: Context,private var dataSet:List<Contact>):RecyclerView.Adapter<ViewHolder>() {

    private val ADMINVIEWTYPE = 99
    private val USERVIEWTYPE = 0

    class ContactViewHolder(val binding: ContactItemBinding):ViewHolder(binding.root)
    class AdminViewHolder(val binding: AdminItemBinding):ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        if(dataSet[position].isAdmin){
            return ADMINVIEWTYPE
        }
        return USERVIEWTYPE
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if(viewType == ADMINVIEWTYPE){
            val binding = AdminItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return AdminViewHolder(binding)
        }
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = dataSet[position]
        if(holder is ContactViewHolder) {
            holder.binding.tvFirstName.text = contact.firstName
            holder.binding.tvLastName.text = contact.lastName
            holder.binding.tvEmail.text = contact.email
            holder.binding.tvNumber.text = contact.number
            holder.binding.layoutInfo.setOnClickListener {

                if (holder.binding.layoutDetails.visibility == GONE) {
                    holder.binding.layoutDetails.visibility = VISIBLE
                } else {
                    holder.binding.layoutDetails.visibility = GONE

                }
            }
            holder.binding.btnFav.setOnClickListener {
                dataSet[position].isFav = !dataSet[position].isFav
                notifyItemChanged(position)

            }
            if (contact.isFav) {
                holder.binding.layoutInfo.setBackgroundColor(Color.RED)

            }
        }else if(holder is AdminViewHolder){

            holder.binding.tvFirstName.text = contact.firstName
            holder.binding.tvLastName.text = contact.lastName
            holder.binding.tvEmail.text = contact.email
            holder.binding.tvNumber.text = contact.number

            holder.binding.layoutInfo.setOnClickListener {

                if (holder.binding.layoutDetails.visibility == GONE) {
                    holder.binding.layoutDetails.visibility = VISIBLE
                } else {
                    holder.binding.layoutDetails.visibility = GONE

                }
            }
            holder.binding.btnFav.setOnClickListener {
                dataSet[position].isFav = !dataSet[position].isFav
                notifyItemChanged(position)

            }
            if (contact.isFav) {
                holder.binding.layoutInfo.setBackgroundColor(Color.RED)

            }
        }
    }

}