package com.example.onbording.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onbording.data.Meal
import com.example.onbording.repository.HomeRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) :ViewModel() {




    private val _getOverMealLiveData=MutableLiveData<List<Meal>>()
    val getOverMealLiveData:LiveData<List<Meal>> = _getOverMealLiveData
    fun getOverMeals(){
        viewModelScope.launch {
            val response=homeRepository.getOverMeal("Seafood")
            if (response.isSuccessful){
                response.body()?.meals.let {
                    _getOverMealLiveData.postValue(it)
                }
            }
        } }




}