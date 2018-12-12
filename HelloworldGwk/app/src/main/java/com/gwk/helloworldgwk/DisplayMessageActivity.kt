package com.gwk.helloworldgwk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_message.*

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val msg: String? = this.intent.getStringExtra(EXTRA_MESSAGE)
        if (msg != null) {
            textView1.text = msg
        }
    }

}
