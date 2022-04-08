package com.example.currencyconverter.repository

import com.example.currencyconverter.data.DataOrException
import com.example.currencyconverter.model.CurrencyRespose
import com.example.currencyconverter.network.CurrencyApi
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val api: CurrencyApi
){

    private  val dataOrException = DataOrException<CurrencyRespose, Boolean, Exception>()

    suspend fun getAllCurrency(): DataOrException<CurrencyRespose, Boolean, Exception>{
        try{
            dataOrException.loading = true
            dataOrException.data = api.getAllCurrency()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception : Exception){
            dataOrException.exception = exception
        }

        return  dataOrException
    }
}