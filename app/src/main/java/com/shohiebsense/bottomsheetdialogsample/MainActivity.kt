package com.shohiebsense.bottomsheetdialogsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DialogButtonClickedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_simple.setOnClickListener {
            BaseDialog(this@MainActivity, supportFragmentManager).showNoListener()
        }

        button_persistent.setOnClickListener {
            BaseDialog(this@MainActivity,supportFragmentManager).showPersistent()
        }

        button_persistent_loading.setOnClickListener {
            BaseDialog(this@MainActivity,supportFragmentManager).showPersistentLoading()
        }


        button_show_message_only.setOnClickListener {
            BaseDialog(this@MainActivity, supportFragmentManager).showNoListenerMessageOnly()
        }

        button_show_yes_no.setOnClickListener {
            BaseDialog(this@MainActivity,supportFragmentManager).showYesNo()
        }


    }


    override fun onDialogDismissed(state: Int) {

    }


}
