package com.nasahapps.kson

import org.json.JSONArray
import org.json.JSONObject

actual class JsonArray actual constructor(json: String) {

    private val array = JSONArray(json)

    actual constructor(block: JsonArray.() -> Unit) : this("[]") {
        block()
    }

    actual fun length() = array.length()

    actual fun toList() = array.toList()

    override fun toString(): String {
        return array.toString()
    }

    actual fun put(value: Any) {
        array.put(value)
    }

    actual fun put(value: Boolean) {
        array.put(value)
    }

    actual fun put(value: Double) {
        array.put(value)
    }

    actual fun put(value: Long) {
        array.put(value)
    }

    actual fun put(value: String) {
        array.put(value)
    }

    actual fun put(value: Map<String, Any>) {
        val obj = JSONObject(value)
        array.put(obj)
    }

    actual fun put(value: JsonObject) {
        val obj = JSONObject(value.toString())
        array.put(obj)
    }

    actual fun put(value: List<Any>) {
        val arr = JSONArray(value)
        array.put(arr)
    }

    actual fun put(value: JsonArray) {
        val arr = JSONArray(value.toString())
        array.put(arr)
    }

    actual fun put(index: Int, value: Any) {
        array.put(index, value)
    }

    actual fun put(index: Int, value: Boolean) {
        array.put(index, value)
    }

    actual fun put(index: Int, value: Double) {
        array.put(index, value)
    }

    actual fun put(index: Int, value: Long) {
        array.put(index, value)
    }

    actual fun put(index: Int, value: String) {
        array.put(index, value)
    }

    actual fun put(index: Int, value: Map<String, Any>) {
        val obj = JSONObject(value)
        array.put(index, obj)
    }

    actual fun put(index: Int, value: JsonObject) {
        val obj = JSONObject(value.toString())
        array.put(index, obj)
    }

    actual fun put(index: Int, value: List<Any>) {
        val arr = JSONArray(value)
        array.put(index, arr)
    }

    actual fun put(index: Int, value: JsonArray) {
        val arr = JSONArray(value.toString())
        array.put(index, arr)
    }

    actual fun get(index: Int) = array.opt(index)

    actual fun getJsonObject(index: Int): JsonObject? {
        array.optJSONObject(index)?.toString()?.let {
            return JsonObject(it)
        }

        return null
    }

    actual fun getJsonArray(index: Int): JsonArray? {
        array.optJSONArray(index)?.toString()?.let {
            return JsonArray(it)
        }

        return null
    }

    actual fun getBoolean(index: Int) = array.optBoolean(index)

    actual fun getDouble(index: Int) = array.optDouble(index)

    actual fun getLong(index: Int) = array.optLong(index)

    actual fun getString(index: Int) = array.optString(index, null)


}