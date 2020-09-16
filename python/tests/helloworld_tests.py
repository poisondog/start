from .test_setting import *
from mockito import mock, verify
import demo.helloworld as helloworld

class HelloWorldTest(unittest.TestCase):
	def testHelloworld(self):
		out = mock()
		helloworld.helloworld(out)
		verify(out).write("Hello world of Python\n")
	def testGet(self):
		self.assertEqual("Hello world of Python\n", helloworld.getHello());

if __name__ == '__main__':
	unittest.main()
