//package com.example.finaluri
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//
//
//class PersonRecyclerAdapter(private val persons: List<User>): RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder>() {
//    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
//        private val textView: TextView = itemView.findViewById(R.id.saxeli)
//        private val textView2: TextView = itemView.findViewById(R.id.textView6)
//        private val number: TextView = itemView.findViewById(R.id.textView3)
//
//        fun setData(person: User) {
//
//            Glide.with(itemView).load(person.imageuri).into(imageView)
//
//            textView.text = person.name
//            number.text = person.textView3
//            textView2.text = person.textView6
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_page, parent, false)
//        return PersonViewHolder(itemView)
//    }
//    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
//        holder.setData(persons[position])
//
//    }
//
//    override fun getItemCount() = persons.size
//}