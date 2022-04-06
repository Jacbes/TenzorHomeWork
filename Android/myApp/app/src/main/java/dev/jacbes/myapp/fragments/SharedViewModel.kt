package dev.jacbes.myapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val mutableMessage = MutableLiveData<String>()
    private val mutableCountMessage = MutableLiveData(0)

    val message: LiveData<String>
        get() = mutableMessage

    fun changeMessage(inMessage: String) {
        mutableCountMessage.value = mutableCountMessage.value!!.inc()
        mutableMessage.value = "$inMessage (message changed: ${mutableCountMessage.value})"
    }

}