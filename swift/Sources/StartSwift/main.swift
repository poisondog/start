
import libStartSwift

let todo = Student(name: "Jack", id: 1)
print(libStartSwift.str + ", " + todo.getName())

func hello3(_ name: String, _ age: Int) {
	print("\(name) is \(age) years old .")
}

hello3("Jack", 33)
