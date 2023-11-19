package com.example.fooddelivery.domain.use_case.auth

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<Resource<SessionToken>> {
        return flow {
            try {
                emit(Resource.Loading())
                val sessionToken = repository.login(email, password)
                emit(Resource.Success(sessionToken))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}