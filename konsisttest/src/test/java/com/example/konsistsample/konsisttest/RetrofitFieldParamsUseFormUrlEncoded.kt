package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAnnotationNamed
import com.lemonappdev.konsist.api.ext.list.withParameter
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class RetrofitFieldParamsUseFormUrlEncoded {
    @Test
    fun `verify post network requests with field parameters should have FormUrlEncoded annotation`() {
        Konsist.scopeFromProduction()
            .functions()
            .withAnnotationNamed("POST")
            .withParameter {
                it.hasAnnotationWithName("Field")
            }
            .assertTrue {
                it.hasAnnotationWithName("FormUrlEncoded")
            }
    }
}
