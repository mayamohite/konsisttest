package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist

import org.junit.Test

class InterfacePropertiesAndFunctionsHasKDoc {
    @Test
    fun `verify Kdoc is written for interface properties and functions`() {
        Konsist
            .scopeFromProject("core")
            .interfaces()
            .forEach {
                it.properties().all { it.hasKDoc } && it.functions().all { it.hasKDoc }
            }
    }
}
