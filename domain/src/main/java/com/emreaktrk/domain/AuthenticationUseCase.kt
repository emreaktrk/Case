package com.emreaktrk.domain

import com.emreaktrk.core.model.Token
import com.emreaktrk.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(
    private val repo: UserRepository,
) : UseCase<AuthenticationUseCase.Params, Token>() {
    override suspend fun onInvoke(input: Params): Flow<Token> {
        return flow {
            if (input.email.isNullOrEmpty()) {
                throw NullPointerException("E-mail can not be null.")
            }

            if (input.password.isNullOrEmpty()) {
                throw NullPointerException("Password can not be null.")
            }

            if (input.password.length < 6) {
                throw IllegalArgumentException("Password must be at least 6 length.")
            }

            val token = repo.authentication(input.email, input.password)
            emit(token)
        }
    }

    data class Params(
        val email: String?,
        val password: String?,
    )
}