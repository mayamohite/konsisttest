package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.imports
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import org.junit.Test

class ViewModelsShouldNotAccessAndroidResources {
    @Test
    fun `verify view models don't have android resource import`() {
        Konsist.scopeFromProduction(moduleName = "presentation")
            .files
            .withNameEndingWith("ViewModel")
            .imports
            .assertFalse {
                it.hasNameStartingWith("com.example.konsistsample.presentation.R")
            }
    }
}
