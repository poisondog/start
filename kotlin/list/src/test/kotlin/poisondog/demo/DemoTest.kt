
package poisondog

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DemoTest {
	@Test fun testValOutClass() {
		assertEquals(3.1416, pi)
		assertEquals(3.1419, poisondog.pi())
		assertEquals(6.2838, poisondog.pi() * "2".toInt())
		assertEquals(6.2838, poisondog.pi(rate=2.0))
		assertEquals(7.2838, poisondog.pi(rate=2.0, plus=1.0))
		assertEquals(7.2838, poisondog.pi(1.0, 2.0))
	}

	@Test fun testClassVal() {
		var d = Demo();
		assertEquals(3.1415, d.pi)
	}

	@Test fun testVararg() {
		var d = Demo();
		assertEquals(3.14159265359, d.append(9, 26, 5, 35, 9))
	}
	@Test fun testPrint() {
		var d = Demo();
		d.print()
		d.print("Jack")
		poisondog.sayHello("Adam")
	}
	@Test fun testArray() {
		var d = Demo();
		d.tryArray()
	}
	@Test fun testMap() {
		var d = Demo();
		d.tryMap()
	}
}
