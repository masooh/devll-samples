package org.devll.samples.kotlin.designpattern.non

class Light {
    fun turnOn() = println("light is on")
    fun turnOff() = println("light is off")
}

class Shutter {
    fun moveUp() = println("shutter is up")
    fun moveDown() = println("shutter is down")
}

class Switch(private val light: Light, private val shutter: Shutter) {
    fun execute(deviceName: String, commandName: String) {
        when (deviceName) {
            "light" -> {
                when (commandName) {
                    "on" -> light.turnOn()
                    "off" -> light.turnOff()
                }
            }
            "shutter" -> {
                when (commandName) {
                    "on" -> shutter.moveUp()
                    "off" -> shutter.moveDown()
                }
            }
        }
    }
}

fun main() {
    val light = Light()
    val shutter = Shutter()

    val switch = Switch(light, shutter)

    switch.execute("light", "on")
    switch.execute("shutter", "on")
    switch.execute("light", "off")
    switch.execute("shutter", "off")
}
