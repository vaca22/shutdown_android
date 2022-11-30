package com.vaca.myapplication

import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import android.os.SystemClock
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream
import java.io.IOException
import java.lang.reflect.InvocationTargetException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.fuck).setOnClickListener {
            shutdown2()
        }

    }

    /**
     * 关闭屏幕 ，其实是使系统休眠
     *
     */
    fun goToSleep(context: Context) {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        try {
            powerManager.javaClass.getMethod(
                "goToSleep",
                *arrayOf<Class<*>?>(Long::class.javaPrimitiveType)
            ).invoke(powerManager, SystemClock.uptimeMillis())
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }
    }


    fun shutdown_sys() {
        val chperm: Process
        try {
            chperm = Runtime.getRuntime().exec("su")
            val os = DataOutputStream(chperm.outputStream)
            os.writeBytes("input keyevent 26\n")
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
                .exec(arrayOf("su","-c", "input keyevent 26"))
            proc.waitFor()
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }
}