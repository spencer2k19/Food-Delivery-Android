package com.example.fooddelivery.common


import android.content.Context
import android.content.SharedPreferences
import com.example.fooddelivery.common.Constants.PREFS_NAME
import com.example.fooddelivery.common.Constants.PREFS_TOKEN_DATA
import com.example.fooddelivery.common.Constants.PREFS_USER
import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.model.User
import com.google.gson.Gson



object PrefSingleton {

    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
    }

    fun saveBool(objectReference: String?, value: Boolean?) {
        editor!!.putBoolean(objectReference, value!!)
        editor!!.commit()
    }


    fun saveUser(value: User?) {
        saveString(PREFS_USER, Gson().toJson(value))
    }

    fun saveTokenData(value: SessionToken?) {
        saveString(PREFS_TOKEN_DATA,Gson().toJson(value))
    }

    fun getUser(): User? {
        val userData = getString(PREFS_USER) ?: return null
        return Gson().fromJson(userData,User::class.java)
    }

    fun getTokenData(): SessionToken? {
        val tokenData = getString(PREFS_TOKEN_DATA)
        return Gson().fromJson(tokenData, SessionToken::class.java)
    }



    private fun saveString(objectReference: String?, value: String?) {
        editor!!.putString(objectReference, value)
        editor!!.commit()
    }

    fun removeString(objectReference: String?) {
        editor!!.remove(objectReference)
        editor!!.commit()
    }

    fun saveInt(objectReference: String?, value: Int) {
        editor!!.putInt(objectReference, value)
        editor!!.commit()
    }

    fun clear() {

        editor!!.clear()
        editor!!.apply()
    }


    fun getBool(objectReference: String?): Boolean {
        return sharedPreferences!!.getBoolean(objectReference, false)
    }

    fun getString(objectReference: String?): String? {
        return sharedPreferences!!.getString(objectReference, "")
    }


}