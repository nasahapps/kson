package com.nasahapps.kson

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class JsonTest {

    private val JSON = """
        {
            "bool": true,
            "double": 1.0,
            "string": "string",
            "long": 1234,
            "object": {
                "something": true,
                "array": [1, 2, 3]
            },
            "array": [true, false]
        }
    """.trimIndent()

    @Test
    fun testGettingBoolean() {
        val obj = JsonObject(JSON)
        assertTrue(obj.getBoolean("bool"))
    }

    @Test
    fun testGettingDouble() {
        val obj = JsonObject(JSON)
        assertEquals(1.0, obj.getDouble("double"))
    }

    @Test
    fun testGettingLong() {
        val obj = JsonObject(JSON)
        assertEquals(1234, obj.getLong("long"))
    }

    @Test
    fun testGettingString() {
        val obj = JsonObject(JSON)
        assertEquals("string", obj.getString("string"))
    }

    @Test
    fun testGettingNull() {
        val obj = JsonObject(JSON)
        assertNull(obj.getJsonObject("blahblah"))
    }

    @Test
    fun testGettingWrongType() {
        val obj = JsonObject(JSON)
        assertEquals(0, obj.getLong("bool"))
    }

    @Test
    fun testGettingObject() {
        val obj = JsonObject(JSON)
        val actual = obj.getJsonObject("object")
        assertTrue(actual!!.getBoolean("something"))
        assertEquals(actual.getJsonArray("array")?.getLong(0), 1)
    }

    @Test
    fun testGettingArray() {
        val obj = JsonObject(JSON)
        val actual = obj.getJsonArray("array")
        assertEquals(actual?.getBoolean(0), true)
    }

    @Test
    fun testPuttingObjectValues() {
        val obj = JsonObject()
        obj.put("bool", true)
        obj.put("double", 1.0)
        obj.put("long", 1234L)
        obj.put("string", "string")
        obj.put(
            "object", JsonObject(
                """
            { "one": 1, "two": 2 }
        """.trimIndent()
            )
        )
        obj.put("array", JsonArray("[1,2,3]"))
        obj.put("map", mapOf("true" to false, "5" to 6))
        obj.put("list", listOf("thing", true))

        assertTrue(obj.getBoolean("bool"))
        assertEquals(1.0, obj.getDouble("double"))
        assertEquals(1234, obj.getLong("long"))
        assertEquals("string", obj.getString("string"))
        assertEquals(1, obj.getJsonObject("object")?.getLong("one"))
        assertEquals(2, obj.getJsonArray("array")?.getLong(1))
        assertEquals(6, obj.getJsonObject("map")?.getLong("5"))
        assertEquals("thing", obj.getJsonArray("list")?.getString(0))
    }

    @Test
    fun testPuttingArrayValues() {
        val array = JsonArray()
        array.put(true)
        array.put(1.0)
        array.put(1234)
        array.put("string")
        array.put(
            JsonObject(
                """
            { "one": 1, "two": 2 }
        """.trimIndent()
            )
        )
        array.put(JsonArray("[1,2,3]"))
        array.put(mapOf("true" to false, "5" to 6))
        array.put(listOf("thing", true))

        assertTrue(array.getBoolean(0))
        assertEquals(1.0, array.getDouble(1))
        assertEquals(1234, array.getLong(2))
        assertEquals("string", array.getString(3))
        assertEquals(1, array.getJsonObject(4)?.getLong("one"))
        assertEquals(2, array.getJsonArray(5)?.getLong(1))
        assertEquals(6, array.getJsonObject(6)?.getLong("5"))
        assertEquals("thing", array.getJsonArray(7)?.getString(0))
    }

}