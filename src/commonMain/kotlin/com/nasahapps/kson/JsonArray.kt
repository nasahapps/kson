package com.nasahapps.kson

expect class JsonArray(json: String = "[]") : Iterable<Any> {

    constructor(block: JsonArray.() -> Unit)

    fun length(): Int
    fun toList(): List<Any>
    override fun toString(): String

    fun put(value: Any)
    fun put(value: Boolean)
    fun put(value: Double)
    fun put(value: Long)
    fun put(value: String)
    fun put(value: Map<String, Any>)
    fun put(value: List<Any>)
    fun put(value: JsonObject)
    fun put(value: JsonArray)

    fun put(index: Int, value: Any)
    fun put(index: Int, value: Boolean)
    fun put(index: Int, value: Double)
    fun put(index: Int, value: Long)
    fun put(index: Int, value: String)
    fun put(index: Int, value: Map<String, Any>)
    fun put(index: Int, value: List<Any>)
    fun put(index: Int, value: JsonObject)
    fun put(index: Int, value: JsonArray)

    fun get(index: Int): Any?
    fun getJsonObject(index: Int): JsonObject?
    fun getJsonArray(index: Int): JsonArray?
    fun getBoolean(index: Int): Boolean
    fun getDouble(index: Int): Double
    fun getLong(index: Int): Long
    fun getString(index: Int): String?


}