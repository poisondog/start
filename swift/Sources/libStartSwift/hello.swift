import Foundation

public var str = "Hello"

class Custom {
	func say() throws -> String {
		print(str)
		return str
	}
}
