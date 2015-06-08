package json.tests

import java.util.*
import kotlin.Pair
import kotlin.reflect.KMemberProperty

library
fun <T> forEachField(o: T, block: T.(Pair<String, dynamic>) -> Unit): Unit = noImpl

fun <T> json(block: T.() -> Unit): T = (js("({})")as T).let { obj -> obj.block(); obj }

data class A(val a: String, val list: List<String>, val map: Map<String, String>) {
    companion object {
        // to be generated
        fun fromJson(json: dynamic): A {
            val a = json.a?.toString() !!
            val list = (json.list as Array<String>?)?.toList() ?: emptyList()
            val map = LinkedHashMap<String, String>()
            forEachField(json.map) {
                map[it.first] = it.second
            }

            return A(a, list, map)
        }
    }
}

fun main(args: Array<String>) {
    val o = json<dynamic> {
        a = "a"
        b = 2
        list = arrayOf("a", "b", "c")
        map = json {
            x = "x1"
            y = "y2"
        }
    }

    println(A.fromJson(o))
}
