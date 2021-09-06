package com.example.demo

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.example.demo")
		.start()
}

