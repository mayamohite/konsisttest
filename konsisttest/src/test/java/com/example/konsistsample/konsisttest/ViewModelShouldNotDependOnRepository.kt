package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.constructors
import com.lemonappdev.konsist.api.ext.list.parameters
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import org.junit.Test

class ViewModelShouldNotDependOnRepository {
    @Test
    fun `verify view models are not dependent on repository`() {
        Konsist.scopeFromProduction()
            .classes()
            .withNameEndingWith("ViewModel")
            .constructors
            .parameters
            .assertFalse {
                it.type.name.endsWith("Repository")
            }
    }
}
