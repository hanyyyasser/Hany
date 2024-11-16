package com.example.myapplication24.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.myapplication24.data.User_DataBase

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = User_DataBase.GetDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

//    fun isUserProfileComplete(userId: Int, callback: (Boolean) -> Unit) {
//        viewModelScope.launch {
//            val isComplete = withContext(Dispatchers.IO) {
//                repository.isUserProfileComplete(userId)
//            }
//            callback(isComplete)
//        }
//    }
}