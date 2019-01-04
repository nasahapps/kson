package com.nasahapps.kson

expect class JsonObject(json: String = "{}") {

    constructor(block: JsonObject.() -> Unit)

    fun keys(): List<String>
    fun toMap(): Map<String, Any>
    fun string(): String

    fun put(key: String, value: Any)
    fun put(key: String, value: Boolean)
    fun put(key: String, value: Double)
    fun put(key: String, value: Long)
    fun put(key: String, value: String)
    fun put(key: String, value: Map<String, Any>)
    fun put(key: String, value: List<Any>)
    fun put(key: String, value: JsonObject)
    fun put(key: String, value: JsonArray)

    fun get(key: String): Any?
    fun getJsonObject(key: String): JsonObject?
    fun getJsonArray(key: String): JsonArray?
    fun getBoolean(key: String): Boolean
    fun getDouble(key: String): Double
    fun getLong(key: String): Long
    fun getString(key: String): String?

}