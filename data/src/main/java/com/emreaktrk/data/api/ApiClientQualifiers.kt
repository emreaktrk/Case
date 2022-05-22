package com.emreaktrk.data.api

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthRequired

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class NoAuthRequired