/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package poisondog.demo.app

import poisondog.demo.utilities.StringUtils

fun main() {
	val tokens = StringUtils.split(MessageUtils.getMessage())
	println(StringUtils.join(tokens))
}