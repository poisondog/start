import XCTest
@testable import libStartSwift


class TodoTests: XCTestCase {

	override class func setUp() { // 1.
		super.setUp()
		// This is the setUp() class method.
		// It is called before the first test method begins.
		// Set up any overall initial state here.
	}

	override func setUp() { // 2.
		super.setUp()
		// This is the setUp() instance method.
		// It is called before each test method begins.
		// Set up any per-test state here.
	}

	func testMethod2() { // 5.
		// This is the second test method.
		// Your testing code goes here.
		addTeardownBlock { // 6.
			// Called when testMethod2() ends.
		}
		addTeardownBlock { // 7.
			// Called when testMethod2() ends.
		}
	}

	func testInitSetsTitle() {
		let adam = Student(name: "Adam", id: 1)
		XCTAssertEqual(adam.name, "Adam", "Incorrect title")
	}

	func testChangeName() {
		let adam = Student(name: "Adam", id: 1)
		adam.setName(name: "Jack")
		XCTAssertEqual(adam.getName(), "Jack", "Incorrect title")
	}

	func testInitTranscript() {
		let t = Transcript(math: 100, english: 60, history: 80)
		XCTAssertEqual(t.math, 100, "Incorrect title")
		XCTAssertEqual(t.english, 60, "Incorrect title")
		XCTAssertEqual(t.history, 80, "Incorrect title")
	}

	override func tearDown() { // 8.
		// This is the tearDown() instance method.
		// It is called after each test method completes.
		// Perform any per-test cleanup here.
		super.tearDown()
	}

	override class func tearDown() { // 9.
		// This is the tearDown() class method.
		// It is called after all test methods complete.
		// Perform any overall cleanup here.
		super.tearDown()
	}

}
