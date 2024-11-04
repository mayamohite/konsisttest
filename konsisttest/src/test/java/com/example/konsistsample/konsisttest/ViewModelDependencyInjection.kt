package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withoutName
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class ViewModelDependencyInjection {
    @Test
    fun `verify view model instance is provided with DI`() {
        Konsist.scopeFromProduction()
            .classes()
            .withoutName(*BASELINE)
            .withNameEndingWith("ViewModel")
            .assertTrue {
                it.hasAnnotationWithName("HiltViewModel", "KoinViewModel")
            }
    }

    companion object {
        private val BASELINE = arrayOf("ProductViewModel", "HighlightViewModel")
    }
}
