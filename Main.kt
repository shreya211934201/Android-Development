package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.database.DatabaseView
import com.example.sqldatabase.DBHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(applicationContext)
        val submitbtn = this.findViewById<Button>(R.id.mySubmitButton);
        val viewBtn = this.findViewById<Button>(R.id.myViewButton);

        fun register():Boolean? {
            val name = this.findViewById<EditText>(R.id.nameTextBox);
            val mobno = this.findViewById<EditText>(R.id.phoneTextBox);
            val email = this.findViewById<EditText>(R.id.emailTextBox);
            val addre = this.findViewById<EditText>(R.id.addTextBox);
            val manu = this.findViewById<EditText>(R.id.manuTextBox)
            val model = this.findViewById<EditText>(R.id.modelTextBox)
            val year = this.findViewById<EditText>(R.id.yearTextbox)

            return dbHelper.registerUser(mobno.text.toString(), name.text.toString(),
                email.text.toString(), addre.text.toString(), manu.text.toString(),
                model.text.toString(), year.text.toString());
        }
        submitbtn.setOnClickListener {
            if(register() == true) Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT).show()
            else Toast.makeText(applicationContext, "Unable to register!", Toast.LENGTH_SHORT).show()
        }
        viewBtn.setOnClickListener {
            val viewDBIntent = Intent(this, DatabaseView::class.java)
            startActivity(viewDBIntent)
        }
    }
}
