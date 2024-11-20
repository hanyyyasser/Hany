package com.example.myapplication24.data

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceDatabase {
    private var appContext: Context? = null
    private const val SHARED_PREFERENCES_NAME_KEY = "User data"
    private const val USER_ID = "id"
    private const val USER_NAME_KEY = "name"
    private const val USER_NUMBER_OF_CHILDREN = "number of children"
    private const val USER_ADDRESS = "address"

    fun initSharedPrefDatabase(context: Context?) {
        appContext = context
    }

    private fun getSharedPreference(): SharedPreferences {
        return appContext!!.getSharedPreferences(SHARED_PREFERENCES_NAME_KEY, Context.MODE_PRIVATE)
    }

    private fun setPreference(key: String, value: String) {
        val editor = getSharedPreference().edit()
        editor.putString(key,value)
        editor.apply()
    }

    private fun getPreference(key: String, defaultValue: String): String {
        return getSharedPreference().getString(key, defaultValue)!!
    }

    fun setId(id: String?) {
        setPreference(USER_ID, id!!)
    }

    fun getId() : String {
        return getPreference(USER_ID, "default id")
    }

    fun setName(name: String) {
        setPreference(USER_NAME_KEY, name)
    }

    fun getName(): String {
        return getPreference(USER_NAME_KEY, "default name")
    }

    fun setAddress(address: String) {
        setPreference(USER_ADDRESS, address)
    }

    fun getAddress(): String {
        return getPreference(USER_ADDRESS, "default address")
    }

    fun setNoOfChildren(birthday: String) {
        setPreference(USER_NUMBER_OF_CHILDREN, birthday)
    }

    fun getNoOfChildren(): String {
        return getPreference(USER_NUMBER_OF_CHILDREN, "default birthday")
    }
}