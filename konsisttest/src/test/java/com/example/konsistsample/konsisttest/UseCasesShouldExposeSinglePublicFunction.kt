package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withPublicOrDefaultModifier
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class UseCasesShouldExposeSinglePublicFunction {
    @Test
    fun `verify all use cases has single public function`() {
        val useCaseClasses = Konsist.scopeFromProduction()
            .classes()
            .withNameEndingWith("UseCase")

        useCaseClasses
            .assertFalse {
                it.functions().withPublicOrDefaultModifier().size > 1
            }
        useCaseClasses
            .properties()
            .assertTrue {
                it.hasPrivateModifier
            }
    }
}
