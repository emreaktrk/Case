package com.emreaktrk.data.api.poko.request

data class UserAuthenticationRequest(
    val email: String,
    val password: String,
)