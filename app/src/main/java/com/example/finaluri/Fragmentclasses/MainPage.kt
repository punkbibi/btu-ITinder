package com.example.finaluri.Fragmentclasses

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.example.finaluri.Friends
//import com.example.finaluri.PersonRecyclerAdapter
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainPage:Fragment(R.layout.profile_fragment) {
//    private var myfriends = arrayListOf<String>()
////    private var friendslist = arrayListOf<Friends>()
    private var database = FirebaseDatabase.getInstance().getReference("users")
//    private  lateinit var useruids: ArrayList<String>
////    private lateinit var recyclerAdapter: PersonRecyclerAdapter
//    private lateinit var recyclerview: RecyclerView
    private lateinit var storagereference: StorageReference
//    private lateinit var frnd1: ArrayList<String>
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        println("hello")
         textView1= view.findViewById(R.id.textView11)
         textView2= view.findViewById(R.id.textView12)
         textView3= view.findViewById(R.id.textView13)
         textView4= view.findViewById(R.id.textView14)
         textView5= view.findViewById(R.id.textView15)
        imageView = view.findViewById(R.id.imageView2)
        val user = FirebaseAuth.getInstance().currentUser
        val name = user?.uid.toString()
        println(user)
        println(name)
        storagereference = FirebaseStorage.getInstance().getReference("users")
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(name).get().addOnSuccessListener { if(it.exists()){
            textView1.text = it.child("fullname").value.toString()
        }


        }
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(name).get().addOnSuccessListener { if(it.exists()){
            textView2.text = it.child("bio").value.toString()
            println(it.child("bio").value.toString())
        }



        }
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(name).get().addOnSuccessListener { if(it.exists()){
            textView3.text = it.child("fakulteti").value.toString()
        }


        }
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(name).get().addOnSuccessListener { if(it.exists()){
            textView4.text = it.child("age").value.toString()
        }


        }
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(name).get().addOnSuccessListener { if(it.exists()){
            textView5.text = it.child("zodiac").value.toString()
        }


        }
        storagereference.child(name).downloadUrl.addOnSuccessListener { uri -> val imag = uri
        Glide.with(this@MainPage).load(imag).into(imageView)}





//        recyclerview = view.findViewById(R.id.recycle)
//        storagereference = FirebaseStorage.getInstance().getReference("users")
//
//        val ako = database.getReference("users")
//
//        val postListener = object : ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                println("mamiko")
//                for(usersnapshot in dataSnapshot.children){
//                    val uid = usersnapshot.key
//                    if(uid != null) {
//                        useruids.add(uid.toString())
//                    }
//                }
//                println(useruids)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//
//                Log.w("ValueEventListener", "loadPost:onCancelled", databaseError.toException())
//            }
//        }
//
//        ako.addValueEventListener(postListener)

        return view

    }



}