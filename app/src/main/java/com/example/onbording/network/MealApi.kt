package com.example.onbording.network




import com.example.onbording.data.OverList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {


    @GET("filter.php")
    suspend fun getOverMeal(@Query("c") categoryName:String):Response<OverList>



}