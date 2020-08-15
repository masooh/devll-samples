package org.devll.samples.kotlin.designpattern

sealed class Drink {
    fun prepareDrink() {
        println("prepare ${this.javaClass.simpleName} ...")

        cookWater()
        addIngredient()
        fillCup()

        println("... finished\n")
    }

    /** template method */
    protected abstract fun addIngredient()

    private fun cookWater() = println("cook water")
    private fun fillCup() = println("fill cup")
}

object Coffee : Drink() {
    override fun addIngredient() = println("add sugar and milk")
}

object Tea : Drink() {
    override fun addIngredient() = println("add lemon")
}


fun main() {
    Coffee.prepareDrink()
    Tea.prepareDrink()
}