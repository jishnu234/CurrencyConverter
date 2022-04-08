package com.example.currencyconverter.model

import com.google.gson.annotations.SerializedName

data class CurrencyRespose(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("time_next_update_unix")
	val timeNextUpdateUnix: Int? = null,

	@field:SerializedName("time_next_update_utc")
	val timeNextUpdateUtc: String? = null,

	@field:SerializedName("provider")
	val provider: String? = null,

	@field:SerializedName("time_eol_unix")
	val timeEolUnix: Int? = null,

	@field:SerializedName("documentation")
	val documentation: String? = null,

	@field:SerializedName("rates")
	val rates: Map<String, Double>? = null,

	@field:SerializedName("time_last_update_unix")
	val timeLastUpdateUnix: Int? = null,

	@field:SerializedName("base_code")
	val baseCode: String? = null,

	@field:SerializedName("time_last_update_utc")
	val timeLastUpdateUtc: String? = null,

	@field:SerializedName("terms_of_use")
	val termsOfUse: String? = null
)