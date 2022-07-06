package com.example.mvvm_first.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_first.models.TvShowItem
import com.example.mvvm_first.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val respository: TvShowRepository): ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvshow: LiveData<List<TvShowItem>>
        get() = _response

    init {
        getAllTvShow()
    }

    private fun getAllTvShow() = viewModelScope.launch {
        respository.getTvShows().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getAllTvShows Error: ${response.code()}")
            }
        }
    }
}