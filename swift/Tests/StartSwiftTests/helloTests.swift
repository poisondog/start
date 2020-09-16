
import XCTest
@testable import libStartSwift

class helloTests: XCTestCase {
	func testInitSetsTitle() {
		XCTAssertEqual(str, "Hello", "Incorrect title")
	}
}
