package com.example.currencyconverter.network

import com.example.currencyconverter.model.CurrencyRespose
import retrofit2.http.GET

interface CurrencyApi{

    @GET("latest")
    suspend fun getAllCurrency(): CurrencyRespose
}