package com.example.konsistsample.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAnnotationOf
import com.lemonappdev.konsist.api.verify.assertTrue
import dagger.Component
import dagger.Module
import org.junit.Test

class DaggerClassesShouldInsideDiPackage {
    @Test
    fun `verify all dependency injection classes are inside di package`() {
        Konsist.scopeFromProduction()
            .classes()
            .withAnnotationOf(Component::class, Module::class)
            .assertTrue {
                it.resideInPackage("..di..")
              }
        }
}