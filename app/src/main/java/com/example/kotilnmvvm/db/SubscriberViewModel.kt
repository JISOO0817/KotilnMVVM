package com.example.kotilnmvvm.db

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotilnmvvm.Subscriber
import com.example.kotilnmvvm.WriteActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val writeBtn = MutableLiveData<String>()

    @Bindable
    val saveBtn = MutableLiveData<String>()

    @Bindable
    val deleteBtn = MutableLiveData<String>()

    init{
        writeBtn.value = "Write"
        saveBtn.value = "Save"
        deleteBtn.value = "Delete All"
    }


    fun save(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name,email))
    }

    fun delete(){
        clearAll()
    }

    fun insert(subscriber: Subscriber) : Job = viewModelScope.launch {
            repository.insert(subscriber)
    }

    fun update(subscriber: Subscriber) :Job =  viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) :Job = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll() :Job = viewModelScope.launch {
        repository.deleteAll()
    }
}