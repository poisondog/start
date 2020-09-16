from setuptools import setup, find_packages

setup(
	name='demo',
	version='1.0.0',
	description='first python demo',
	author='Adam Huang',
	author_email='poisondog@gmail.com',
	packages=find_packages(exclude=('tests', 'docs'))
)

