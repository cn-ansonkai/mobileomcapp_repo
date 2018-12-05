package com.gwk.helloworldgwk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.gwk.helloworldgwk.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var textV_dynamic = TextView(this)
        //textV_dynamic.id = View.generateViewId()
        //textV_dynamic.textSize = 20f
        //textV_dynamic.width  = wrap_content
        //textV_dynamic.text = "Hello world text view from code dynamic"
        //textV_dynamic.setOnClickListener {
         //   Toast.makeText(this@MainActivity, "You clicked on TextView 'from code'!", Toast.LENGTH_SHORT).show()
        //}


        //ll_main_layout.addView(textV_dynamic)
    }

    fun sendMessage(view: View) {
        val intent  = Intent(this, DisplayMessageActivity::class.java)
        val msg = editText1.text
        if (msg != null) {
            intent.putExtra(EXTRA_MESSAGE, msg.toString())
            startActivity(intent)
        }
    }
}
