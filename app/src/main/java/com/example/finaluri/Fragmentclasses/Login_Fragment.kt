package com.example.finaluri.Fragmentclasses

import android.content.Intent
import android.net.MailTo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.finaluri.MainMenu
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class Login_Fragment:Fragment(R.layout.main_page) {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var mail: EditText
    private lateinit var password: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        button1 = view.findViewById(R.id.button)
        button2 = view.findViewById(R.id.button3)
        mail = view.findViewById(R.id.Username)
        password = view.findViewById(R.id.password_place)


        button2.setOnClickListener{
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container, Register_fragment())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        button1.setOnClickListener {
            if (!mail.text.isEmpty() && !password.text.isEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(mail.text.toString(), password.text.toString()).addOnSuccessListener {
                   startActivity(Intent(this.requireContext(),MainMenu::class.java))
                }
            }
        }

        return view
    }
}