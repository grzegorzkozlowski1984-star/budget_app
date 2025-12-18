
package com.mybudget.app

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "My Budget app is running"
        tv.textSize = 22f
        setContentView(tv)
    }
}
