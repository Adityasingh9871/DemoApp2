package com.example.demoapp

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {

    private val preferences:SharedPreferences=context.getSharedPreferences("data",Context.MODE_PRIVATE)
    val editor=preferences.edit()

    fun getdata(key:String):Boolean
    {
        return preferences.getBoolean(key,false)
    }

    fun setdata(key:String,value:Boolean)
    {
        editor.apply(){
            putBoolean(key,value)
        }.apply()
    }

    fun set_user_pass(key:String,value:String)
    {
        editor.apply(){
            putString(key,value)
        }.apply()
    }
}