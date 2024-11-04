package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withModifier
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class DataClassesImmutability {
    @Test
    fun `verify data classes are immutable`() {
        Konsist.scopeFromProduction()
            .classes()
            .withModifier(KoModifier.DATA)
            .properties()
            .assertTrue {
                it.hasValModifier
            }
    }
}