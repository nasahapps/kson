package com.nasahapps.kson

import org.json.JSONArray
import org.json.JSONObject

actual class JsonObject actual constructor(json: String) {

    private val obj = JSONObject(json)

    actual constructor(block: JsonObject.() -> Unit) : this("{}") {
        block()
    }

    actual override fun toString(): String {
        return obj.toString()
    }

    actual fun keys() = obj.keySet().toList()

    actual fun toMap() = obj.toMap()

    actual fun put(key: String, value: Any) {
        obj.put(key, value)
    }

    actual fun put(key: String, value: Boolean) {
        obj.put(key, value)
    }

    actual fun put(key: String, value: Double) {
        obj.put(key, value)
    }

    actual fun put(key: String, value: Long) {
        obj.put(key, value)
    }

    actual fun put(key: String, value: String) {
        obj.put(key, value)
    }

    actual fun put(key: String, value: Map<String, Any>) {
        val json = JSONObject(value)
        obj.put(key, json)
    }

    actual fun put(key: String, value: JsonObject) {
        val json = JSONObject(value.toString())
        obj.put(key, json)
    }

    actual fun put(key: String, value: List<Any>) {
        val array = JSONArray(value)
        obj.put(key, array)
    }

    actual fun put(key: String, value: JsonArray) {
        val array = JSONArray(value.toString())
        obj.put(key, array)
    }

    actual fun get(key: String) = obj.opt(key)

    actual fun getJsonObject(key: String): JsonObject? {
        obj.optJSONObject(key)?.toString()?.let {
            return JsonObject(it)
        }

        return null
    }

    actual fun getJsonArray(key: String): JsonArray? {
        obj.optJSONArray(key)?.toString()?.let {
            return JsonArray(it)
        }

        return null
    }

    actual fun getBoolean(key: String) = obj.optBoolean(key)

    actual fun getDouble(key: String) = obj.optDouble(key)

    actual fun getLong(key: String) = obj.optLong(key)

    actual fun getString(key: String) = obj.optString(key, null)
}