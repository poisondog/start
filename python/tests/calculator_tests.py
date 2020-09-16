from .test_setting import *

import demo.calculator as calculator

class CalculatorTest(unittest.TestCase):

	def setUp(self):
		self.args = (3, 2)

	def tearDown(self):
		self.args = None

	def test_plus(self):
		self.assertEqual(5, calculator.plus(*self.args));

	def test_minus(self):
		self.assertEqual(1, calculator.minus(*self.args));

if __name__ == '__main__':
	unittest.main()
