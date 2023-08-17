package com.season.winter.common.extention.primitive

import android.util.Log
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

inline fun <reified T> String.decodeFromJsonStringSafety(): T? {
    return try {
        val jsonOption = Json {
            ignoreUnknownKeys = true
        }
        jsonOption.decodeFromString<T>(this)
    } catch (e: SerializationException) {
        Log.e(
            "Json.decodeFromStringSafety",
            "SerializationException: ${e.message}"
        )
        null
    }
}