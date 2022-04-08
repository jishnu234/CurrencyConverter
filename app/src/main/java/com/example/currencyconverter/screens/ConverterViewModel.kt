package com.example.currencyconverter.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.DataOrException
import com.example.currencyconverter.model.CurrencyRespose
import com.example.currencyconverter.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {

    val data: MutableState<DataOrException<CurrencyRespose, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    init {
        getAllCurrency()

    }
    private fun getAllCurrency() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllCurrency()
            if (data.value.toString().isNotEmpty()) data.value.loading = false
        }
    }


}