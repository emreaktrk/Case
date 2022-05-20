package com.emreaktrk.data.api

import com.google.gson.JsonArray

data class ResultWrapper<T>(
    val success: Boolean,
    val error: Any?,
    val result: T,
) {
    val errors: List<Pair<String, String>>?
        get() {
            if (error is JsonArray) {
                return error.map { it.asJsonObject }.map {
                    Pair(
                        it["message"].asString,
                        it["param"].asString,
                    )
                }
            }

            return null
        }
}
