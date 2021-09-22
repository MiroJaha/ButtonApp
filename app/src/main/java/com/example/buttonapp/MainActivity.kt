package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    lateinit var number: TextView

    private fun setcolor(num:Int){
        when {
            num>0 -> number.setTextColor(Color.GREEN)
            num<0 -> number.setTextColor(Color.RED)
            else -> number.setTextColor(Color.BLACK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number=findViewById(R.id.Numbers)
        val add=findViewById<Button>(R.id.Plus)
        val min=findViewById<Button>(R.id.Mines)
        number.setTextColor(Color.BLACK)

        var num=0
        var top=1
        var bottom=0

        add.setOnClickListener{
            num++
            setcolor(num)
            number.text= num.toString()
            if(number.currentTextColor==Color.GREEN||number.currentTextColor==Color.BLACK)
                top+=(10*num)
            else
                top-=(10*num)
            number.setPadding(0,0,0,top)
        }

        min.setOnClickListener{
            num--
            setcolor(num)
            number.text= num.toString()
            if(number.currentTextColor==Color.RED||number.currentTextColor==Color.BLACK)
                top+=(10*num)
            else
                top-=(10*num)
            number.setPadding(0,0,0,top)
        }

    }
}