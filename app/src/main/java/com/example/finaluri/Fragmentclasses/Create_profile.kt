package com.example.finaluri.Fragmentclasses

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.finaluri.MainMenu
import com.example.finaluri.R
import com.example.finaluri.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Create_profile:Fragment(R.layout.crate_profile_fragment) {
    private lateinit var database: DatabaseReference
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var editText5: EditText
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private var requestcode = 1
    private lateinit var storageReference: StorageReference
    private lateinit var imageuri: Uri
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewv = inflater.inflate(R.layout.crate_profile_fragment, container, false)
        editText1 = viewv.findViewById(R.id.editTextTextPersonName5)
        editText2 = viewv.findViewById(R.id.editTextTextPersonName6)
        editText3 = viewv.findViewById(R.id.editTextTextPersonName7)
        editText4 = viewv.findViewById(R.id.editTextTextPersonName8)
        editText5 = viewv.findViewById(R.id.editTextTextPersonName9)
        button = viewv.findViewById(R.id.button6)
        imageView = viewv.findViewById(R.id.imageView3)
        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,requestcode)

        }
        button.setOnClickListener {

            database = FirebaseDatabase.getInstance().getReference("users")
            val user = User(
                editText1.text.toString(),
                editText2.text.toString().toInt(),
                editText3.text.toString(),
                editText4.text.toString(),
                editText5.text.toString()
            )
            database.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).setValue(user)
                .addOnSuccessListener { uploadprofilepic() }
        }
        return viewv
    }

    private fun uploadprofilepic() {

        storageReference = FirebaseStorage.getInstance()
            .getReference("users/" + FirebaseAuth.getInstance().currentUser?.uid)
        storageReference.putFile(imageuri).addOnSuccessListener{

            startActivity(Intent(this@Create_profile.requireContext(), MainMenu::class.java))

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == requestcode && resultCode == RESULT_OK && data != null) {
            val selectedImageUri = data.data


            imageView.setImageURI(selectedImageUri)
            if (selectedImageUri != null) {
                imageuri = selectedImageUri

            }
        }
    }
}