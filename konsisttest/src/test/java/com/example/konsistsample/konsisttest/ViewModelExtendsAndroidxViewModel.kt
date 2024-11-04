package com.example.konsistsample.konsisttest

import androidx.lifecycle.ViewModel
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class ViewModelExtendsAndroidxViewModel {
    @Test
    fun `verify view models extends androidx view model`() {
        Konsist.scopeFromProduction()
            .classes()
            .withNameEndingWith(suffix = "ViewModel")
            .assertTrue(additionalMessage = MESSAGE) {
                it.hasParentOf(ViewModel::class)
            }
    }

    companion object {
        const val MESSAGE = "View models should extend Androidx View Model class"
    }
}
