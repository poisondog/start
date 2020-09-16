class Person {
	def name, age
}

def p = new Person(name: 'John', age: 21)
println "${p.name}: ${p.age}"

println "現在月份：${new Date().month}"
println "Square root of 199 is ${Math.sqrt(199)}"
println "運動強度建議每分鐘心跳數不超過 " + (220 - p.age) * 0.9

class NormalFunction {
	def max(a, b) {
		a > b ? a : b
	}
}
def nf = new NormalFunction()
println "${nf.max(18, 24)}"  // return 24


class FunctionalProgramming {
	def max = { a, b ->
		a > b ? a : b
	}
	def min = { a, b ->
		a > b ? b : a
	}
}
def fp = new FunctionalProgramming()
println fp.max(35, 24)  // return 35

def fun = fp.max;
println fun(1, 2);
