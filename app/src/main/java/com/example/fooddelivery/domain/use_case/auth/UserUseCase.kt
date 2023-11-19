package com.example.fooddelivery.domain.use_case.auth

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.User
import com.example.fooddelivery.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    operator fun invoke(authorization: String): Flow<Resource<User>> {
        return flow {
            try {
                emit(Resource.Loading())
                val user = repository.getCurrentUser(authorization)
                emit(Resource.Success(user))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }

}