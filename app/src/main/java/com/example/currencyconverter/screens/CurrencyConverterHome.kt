package com.example.currencyconverter.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconverter.components.InputField



@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun CurrencyConverterHome(viewModel: ConverterViewModel =
                              androidx.lifecycle.viewmodel.compose.viewModel()) {
    var currencyText by remember {
        mutableStateOf("")
    }
    var multiplier by remember {
        mutableStateOf(1.0)
    }

    var currencyMap = viewModel.data.value.data?.rates

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                text = "Currencies",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.Black
            )
            Card(
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.60f),
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                elevation = 8.dp
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    if(currencyMap != null)

                        currencyMap.keys.forEach {
                            item {
                                Row {
                                    Text(
                                        text = it,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "%.2f".format(currencyMap[it]?.times(multiplier)),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                        Spacer(modifier = Modifier.height(4.dp))
                        Divider(modifier = Modifier.fillMaxWidth())
                            }
                        }
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(Color(0xFF2196F3))
            )
            InputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp),
                label = "Dollars",
                value = currencyText,
            ){
                currencyText = it
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                    .border(2.dp, Color.LightGray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.CenterStart
            ){
                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    text = "USD",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.DarkGray.copy(alpha = 0.7f)
                )}//Box
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 12.dp, end = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                ),
                onClick = {
                    multiplier = currencyText.toDoubleOrNull() ?: 1.0
                }) {
                Text(
                    text = "Convert!",
                    color = Color(0xFF2196F3),
                )
            }
        }
    }
}