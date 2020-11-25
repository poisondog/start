
package poisondog

val pi: Double = 3.1416

fun pi(plus:Double=0.0, rate:Double=1.0) : Double {
	return 3.1419 * rate + plus
}

fun sayHello(name:String="") = println("Hello $name")

class Demo {
	val pi: Double = 3.1415
	fun append(vararg input: Int): Double {
		var builder = StringBuilder()
		builder.append(pi.toString())
		for (item in input)
			builder.append(item.toString())
		return builder.toString().toDouble()
	}
	fun print(name:String=""): Unit {
		println("Hello $name")
	}
	fun tryArray() {
		val some = arrayOf("a", "b", "c")
		println(some.size)
		println(some[0])
		println(some.get(0))
		some.forEach{println(it)}
		some.forEach{e -> println(e)}
		some.forEachIndexed{i, e -> println("some[$i] = $e")}
	}
	fun tryMap() {
		val some = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
		some.put(4, "d")
		some.forEach{println(it)}
		some.forEach{key, value -> println("$key: $value")}
		//some.forEachIndexed{i, e -> println("some[$i] = $e")}
		val p = Person("Jack", 18)
		val j = Person()
		j.nickName = "Jacky"
		println(j)
	}
}

class Person (val name:String, var age:Int) {
	var nickName: String? = null
	var gender: Boolean = false
	set(value) {
		field = value
		println("change the nickname to $field")
	}
	get() {
		return field
	}
	init {
		nickName = name
		println("init")
	}
	constructor(): this("Jack", 18) {
		println("secondary constructor")
	}
	init {
		println("another init")
	}
	override fun toString(): String {
		val s = gender ? "He" : "She"
		val o = if(gender) "him" else "her"
		return "$s is $name, you can call $o $nickName"
	}
}
