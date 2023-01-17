package com.example.finaluri.Fragmentclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth

class Register_fragment:Fragment(R.layout.register_fragment) {
    private  lateinit var editText1: EditText
    private  lateinit var editText2: EditText
    private  lateinit var editText3: EditText
    private  lateinit var  button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register_fragment, container, false)
        editText1 = view.findViewById(R.id.editTextTextPersonName2)
        editText2 = view.findViewById(R.id.editTextTextPersonName3)
        editText3 = view.findViewById(R.id.editTextTextPersonName4)
        button = view.findViewById(R.id.button5)
        button.setOnClickListener {
            println("mama sheni")



            if (!editText1.text.isEmpty() && !editText2.text.isEmpty() && !editText3.text.isEmpty()) {
                if (editText2.text.toString() == editText3.text.toString()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        editText1.text.toString(),
                        editText2.text.toString()
                    )
                        .addOnSuccessListener {
                            val fragmentManager = activity?.supportFragmentManager
                            val fragmentTransaction = fragmentManager?.beginTransaction()
                            fragmentTransaction?.replace(R.id.container, Create_profile())
                            fragmentTransaction?.addToBackStack(null)
                            fragmentTransaction?.commit()


                        }
                }
            }
        }
        return view
    }
}