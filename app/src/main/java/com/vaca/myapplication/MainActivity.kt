package com.vaca.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.fuck).setOnClickListener {
            shutdown2()
        }

    }

    fun shutdown_sys() {
        val chperm: Process
        try {
            chperm = Runtime.getRuntime().exec("su")
            val os = DataOutputStream(chperm.outputStream)
            os.writeBytes("shutdown\n")
            os.flush()
            chperm.waitFor()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: InterruptedException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }



    fun shutdown2(){
        try {
            val proc: Process = java.lang.Runtime.getRuntime()
                .exec(arrayOf("su", "-c", "reboot -p"))
            proc.waitFor()
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }
}