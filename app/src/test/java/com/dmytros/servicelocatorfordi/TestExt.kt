package com.dmytros.servicelocatorfordi

import io.mockk.mockk
import io.mockk.spyk
import org.koin.core.parameter.DefinitionParameters
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declare

/**
 * Created by Dima Skopiuk on 01.02.2020.
 */
inline fun <reified T : Any> KoinTest.declareMockk(
    relaxed: Boolean = true,
    crossinline block: T.(DefinitionParameters) -> Unit = {}
): Lazy<T> {
    declare { single<T> { parameters -> mockk(relaxed = relaxed, relaxUnitFun = relaxed) { block(this, parameters) } } }
    return inject()
}

inline fun <reified T : Any> KoinTest.declareSpyk(objectToCopy: T, crossinline block: T.() -> Unit = {}): Lazy<T> {
    declare { single { spyk(objectToCopy) { block(this) } } }
    return inject()
}