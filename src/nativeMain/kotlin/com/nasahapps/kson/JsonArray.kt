package com.nasahapps.kson

import platform.Foundation.NSJSONReadingMutableContainers
import platform.Foundation.NSJSONSerialization
import platform.Foundation.NSJSONWritingPrettyPrinted

actual class JsonArray actual constructor(json: String) : Iterable<Any> {

    private val array: MutableList<Any>

    actual constructor(block: JsonArray.() -> Unit) : this("[]") {
        block()
    }

    init {
        val data = json.nsData()!!
        array = (NSJSONSerialization.JSONObjectWithData(data, NSJSONReadingMutableContainers, null) as List<Any>).toMutableList()
    }

    actual fun length() = array.size

    actual override fun toString(): String {
        val data = NSJSONSerialization.dataWithJSONObject(array, NSJSONWritingPrettyPrinted, null)
        return data.string().toString()
    }

    actual fun toList() = array.toList()

    override fun iterator(): Iterator<Any> {
        return array.iterator()
    }

    actual fun put(value: Any) {
        array.add(value)
    }

    actual fun put(value: Boolean) {
        array.add(value)
    }

    actual fun put(value: Double) {
        array.add(value)
    }

    actual fun put(value: Long) {
        array.add(value)
    }

    actual fun put(value: String) {
        array.add(value)
    }

    actual fun put(value: Map<String, Any>) {
        array.add(value)
    }

    actual fun put(value: JsonObject) {
        put(value.toMap())
    }

    actual fun put(value: List<Any>) {
        array.add(value)
    }

    actual fun put(value: JsonArray) {
        put(value.toList())
    }

    actual fun put(index: Int, value: Any) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: Boolean) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: Double) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: Long) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: String) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: Map<String, Any>) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: JsonObject) {
        put(index, value.toMap())
    }

    actual fun put(index: Int, value: List<Any>) {
        array.add(index, value)
    }

    actual fun put(index: Int, value: JsonArray) {
        put(index, value.toList())
    }

    actual fun get(index: Int): Any? {
        return array.getOrNull(index)
    }

    actual fun getJsonObject(index: Int): JsonObject? {
        try {
            array.getOrNull(index)?.let { obj ->
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

    actual fun getJsonArray(index: Int): JsonArray? {
        try {
            array.getOrNull(index)?.let { obj ->
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

    actual fun getBoolean(index: Int): Boolean {
        return (array.getOrNull(index) as? Boolean) ?: false
    }

    actual fun getDouble(index: Int): Double {
        return (array.getOrNull(index) as? Double) ?: 0.0
    }

    actual fun getLong(index: Int): Long {
        return (array.getOrNull(index) as? Long) ?: 0L
    }

    actual fun getString(index: Int): String? {
        return array.getOrNull(index) as? String
    }


}