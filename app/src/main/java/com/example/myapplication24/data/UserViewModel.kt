package com.example.myapplication24.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val userRepository: UserRepository

    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        userRepository = UserRepository(userDao)
        readAllData = userRepository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }

    private var _name = MutableLiveData<String>()
    val name get() = _name

    fun getName(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _name.postValue(userRepository.getName(userId))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    private var _address = MutableLiveData<String>()
    val address get() = _address

    fun getAddress(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _address.postValue(userRepository.getAddress(userId))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    private var _noOfChild = MutableLiveData<String>()
    val noOfChild get() = _noOfChild

    fun getNoOfChild(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _noOfChild.postValue(userRepository.getNoOfChildren(userId))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    fun isUserProfileComplete(userId: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            val isComplete = withContext(Dispatchers.IO) {
                userRepository.isUserProfileComplete(userId)
            }
            callback(isComplete)
        }
    }
}