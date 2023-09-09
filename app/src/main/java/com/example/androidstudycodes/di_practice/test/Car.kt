package com.example.androidstudycodes.di_practice.test

class Car(
    private val engine: Engine
) {

    fun start() {
        engine.start()
    }
}

fun main() {
    val engine = Engine()
    val gasEngine = Engine.GasEngine()
    val car = Car(engine)
    car.start()
}