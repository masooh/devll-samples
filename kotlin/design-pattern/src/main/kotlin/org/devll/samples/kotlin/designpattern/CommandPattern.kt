package org.devll.samples.kotlin.designpattern

interface Command {
    fun execute()
}

class Light {
    fun turnOn() = println("light is on")
    fun turnOff() = println("light is off")
}
class SwitchOnCommand(private val light: Light) : Command {
    override fun execute() = light.turnOn()
}
class SwitchOffCommand(private val light: Light) : Command {
    override fun execute() = light.turnOff()
}

class Shutter {
    fun moveUp() = println("shutter is up")
    fun moveDown() = println("shutter is down")
}
class MoveUpCommand(private val shutter: Shutter) : Command {
    override fun execute() = shutter.moveUp()
}
class MoveDownCommand(private val shutter: Shutter) : Command {
    override fun execute() = shutter.moveDown()
}

class Switch(private val deviceCommands: Map<String, Map<String, Command>>) {
    fun execute(deviceName: String, commandName: String) = deviceCommands[deviceName]?.get(commandName)?.execute()
}

fun main() {
    val light = Light()
    val shutter = Shutter()

    val switch = Switch(mapOf("light" to mapOf("on" to SwitchOnCommand(light),
                                               "off" to SwitchOffCommand(light)),
                              "shutter" to mapOf("on" to MoveUpCommand(shutter),
                                                 "off" to MoveDownCommand(shutter))))

    switch.execute("light", "on")
    switch.execute("shutter", "on")
    switch.execute("light", "off")
    switch.execute("shutter", "off")
}
