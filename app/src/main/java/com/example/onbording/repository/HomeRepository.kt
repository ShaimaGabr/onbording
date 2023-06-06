package com.example.onbording.repository

import android.util.Log
import com.example.onbording.data.OverList
import com.example.onbording.network.MealApi

import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val mealApi: MealApi
) {

    suspend fun getOverMeal(categoryName:String):Response<OverList>
    {
        val response=mealApi.getOverMeal(categoryName)
        if(response.isSuccessful)
        {
        Log.d("testApp","Success To connected to random meal")
        Log.d("testApp",response.code().toString())
    } else {
        Log.d("testApp","failed To connected to random meal")
        Log.d("testApp",response.code().toString())
    }
    return response
    }

}