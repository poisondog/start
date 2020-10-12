fun getGreeting(): String {
	return "Hello Kotlin"
}

fun getGreeting2() = "Hello Kotlin"

fun sayHello(name:String) {
	var msg = "Hello " + name
	println(msg)
}

fun main() {
	val name: String = "Nate"
	println(name)
	var another: String? = null
	another = "Jack"
	when(another) {
		null -> println("None")
		else -> println(another)
	}
	val a2 = if(another == null) "None" else another
	println(a2)
	val a3 = when(another) {
		null -> "Hi"
		else -> another
	}
	println(a3)
	println(getGreeting())
	sayHello("John")
}
