package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class UiModelsAreNotExposed {
    @Test
    fun `verify ui models are not exposed to other modules`() {
        Konsist.scopeFromProduction(moduleName = "presentation")
            .classes()
            .withNameEndingWith("UiModel")
            .assertTrue {
                it.hasInternalModifier
            }
    }
}