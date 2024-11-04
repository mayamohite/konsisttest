package com.example.konsistsample.konsisttest

import androidx.compose.runtime.Composable
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAnnotationOf
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class ComposeFunctionShouldInsideUiPackage {
    @Test
    fun `verify all compose functions are inside ui package`() {
        Konsist
            .scopeFromProduction()
            .functions()
            .withAnnotationOf(Composable::class)
            .assertTrue {
                it.resideInPackage("..ui..")
            }
    }
}
