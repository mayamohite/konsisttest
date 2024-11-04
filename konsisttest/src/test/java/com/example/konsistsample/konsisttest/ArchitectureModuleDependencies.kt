package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

class ArchitectureModuleDependencies {
    @Test
    fun `verify domain module is not dependent on other modules, data and presentation modules are dependent on domain`() {
        Konsist.scopeFromProduction()
            .assertArchitecture {
                val presentation = Layer(name = "Presentation", "com.example.konsistsample.presentation..")
                val domain = Layer(name = "Domain", "com.example.konsistsample.domain..")
                val data = Layer(name = "Data", "com.example.konsistsample.data..")
                domain.dependsOnNothing()
                data.dependsOn(domain)
                presentation.dependsOn(domain)
            }
    }
}