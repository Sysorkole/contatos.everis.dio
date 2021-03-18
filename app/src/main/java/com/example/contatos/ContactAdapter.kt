package com.example.contatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    val list: MutableList<Contact> = mutableListOf()

    //Responsável pelos elementos visuais de cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        //Inflate -> inflar, ou seja, dizer qual é o layout(xml) responsável por cada item na tela
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    // Responsável por "popular" cada elemento da lista
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // Responsável por dizer o número de elementos da lista
    override fun getItemCount(): Int = list.size

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged() // Notifica o adapter dizendo que a lista dele foi modificada
    }

    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.ivPhoto)
        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }

}