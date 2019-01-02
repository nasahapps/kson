package com.nasahapps.kson

import platform.Foundation.NSJSONReadingMutableContainers
import platform.Foundation.NSJSONSerialization
import platform.Foundation.NSJSONWritingPrettyPrinted

actual class JsonObject actual constructor(json: String) {

    private val obj: MutableMap<String, Any>

    actual constructor(block: JsonObject.() -> Unit) : this("{}") {
        block()
    }

    init {
        val data = json.nsData()!!
        obj = (NSJSONSerialization.JSONObjectWithData(data, NSJSONReadingMutableContainers, null) as Map<String, Any>).toMutableMap()
    }

    override fun toString(): String {
        val data = NSJSONSerialization.dataWithJSONObject(obj, NSJSONWritingPrettyPrinted, null)
        return data.string().toString()
    }

    actual fun keys() = obj.keys.toList()

    actual fun toMap() = obj.toMap()

    actual fun put(key: String, value: Any) {
        obj[key] = value
    }

    actual fun put(key: String, value: Boolean) {
        obj[key] = value
    }

    actual fun put(key: String, value: Double) {
        obj[key] = value
    }

    actual fun put(key: String, value: Long) {
        obj[key] = value
    }

    actual fun put(key: String, value: String) {
        obj[key] = value
    }

    actual fun put(key: String, value: Map<String, Any>) {
        obj[key] = value
    }

    actual fun put(key: String, value: JsonObject) {
        put(key, value.toMap())
    }

    actual fun put(key: String, value: List<Any>) {
        obj[key] = value
    }

    actual fun put(key: String, value: JsonArray) {
        put(key, value.toList())
    }

    actual fun get(key: String): Any? {
        return obj[key]
    }

    actual fun getJsonObject(key: String): JsonObject? {
        try {
            obj[key]?.let { obj ->
                val data = NSJSONSerialization.dataWithJSONObject(obj, NSJSONWritingPrettyPrinted, null)
                val json = data.string()
                if (json != null) {
                    return JsonObject(json)
                }
            }
        } catch (t: Throwable) {
            println(t)
        }

        return null
    }

    actual fun getJsonArray(key: String): JsonArray? {
        try {
            obj[key]?.let { obj ->
                val data = NSJSONSerialization.dataWithJSONObject(obj, NSJSONWritingPrettyPrinted, null)
                val json = data.string()
                if (json != null) {
                    return JsonArray(json)
                }
            }
        } catch (t: Throwable) {
            println(t)
        }

        return null
    }

    actual fun getBoolean(key: String): Boolean {
        return obj[key] as? Boolean ?: false
    }

    actual fun getDouble(key: String): Double {
        return obj[key] as? Double ?: 0.0
    }

    actual fun getLong(key: String): Long {
        return obj[key] as? Long ?: 0L
    }

    actual fun getString(key: String): String? {
        return obj[key] as? String
    }
}