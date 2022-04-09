package dev.jacbes.myapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val mutableMessage = MutableLiveData<String>()

    val message: LiveData<String>
        get() = mutableMessage

    fun changeMessage(inMessage: String) {
        mutableMessage.value = inMessage
    }

}