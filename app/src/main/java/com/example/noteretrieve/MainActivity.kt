package com.example.noteretrieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var bt: Button
    lateinit var bretrive: Button
    lateinit var et: EditText
    lateinit var Rc: RecyclerView
    lateinit var Inputs: ArrayList<String>
    lateinit var db:dbhelper
    var ind =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         db = dbhelper(this)
        Rc = findViewById(R.id.rv)
        Inputs = ArrayList()
        Rc.adapter = adapteritem(this, Inputs)
        Rc.layoutManager = LinearLayoutManager(this)
        bt = findViewById(R.id.b)
        bretrive = findViewById(R.id.bretrive)
        et = findViewById(R.id.et)

        bt.setOnClickListener { AddToDB() }
        bretrive.setOnClickListener { retriveFromDB() }


    }

    fun AddToDB() {
        db.addNote(et.text.toString())
        et.text.clear()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    fun retriveFromDB() {
        var note = db.retriveNote(et.text.toString())
        et.text.clear()
        Inputs.add(note)
        Rc.adapter?.notifyDataSetChanged()

    }
}