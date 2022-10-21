package com.example.dinnerdeciderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val arrayList = arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var decideButton = findViewById<Button>(R.id.decide_button)
        var foodText = findViewById<TextView>(R.id.food_text)
        var editText = findViewById<EditText>(R.id.edit_text)
        decideButton.setOnClickListener {
            var food = arrayList.random()
            while (food == foodText.text){
                food = arrayList.random()
            }
            foodText.text = food
        }
        var addButton = findViewById<Button>(R.id.add_food)
        addButton.setOnClickListener {
            if(editText.text.isNullOrEmpty()){
                Toast.makeText(applicationContext,"No food name typed",Toast.LENGTH_SHORT).show()
            }else{
                arrayList.add(editText.text.toString())
                editText.text.clear()
            }
        }
    }
}