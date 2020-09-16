public struct Transcript {
	let math: Int
	let english: Int
	let history: Int
}

public class Student {
	let studentID: Int
	var name: String
	var power: Bool
	var transcript: Transcript

	public init(name: String, id: Int) {
		self.name = name
		self.studentID = id
		self.power = false
		self.transcript = Transcript(math: 0, english: 0, history: 0)
	}

	public func getName() -> String {
		return self.name
	}

	public func setName(name: String) {
		self.name = name
	}

	public func setTranscript(transcript: Transcript) {
		self.transcript = transcript
	}

	/// This function returns a *hello* string for a given `subject`.
	///
	/// - Warning: The returned string is not localized.
	///
	/// Usage:
	///
	///     println(hello("Markdown")) // Hello, Markdown!
	///
	/// - Parameter subject: The subject to be welcomed.
	///
	/// - Returns: A hello string to the `subject`.
	public func toString() {
		let string = "My Math score is \(self.transcript.math) ."
		print(string)
	}

}
