
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
	fun defaultForEach() {
		val some = arrayOf("a", "b", "c")
		println(some.size)
		println(some[0])
		println(some.get(0))
		some.forEach{e -> println(e)}
	}
}
