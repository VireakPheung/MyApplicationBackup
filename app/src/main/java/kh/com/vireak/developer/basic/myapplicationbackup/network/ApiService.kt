package kh.com.vireak.developer.basic.myapplicationbackup.network

import kh.com.vireak.developer.basic.myapplicationbackup.feature.userApi.UserApiVm
import kh.com.vireak.developer.basic.myapplicationbackup.model2.request.UserApiRequest
import kh.com.vireak.developer.basic.myapplicationbackup.model2.response.UpdateUserResponse
import kh.com.vireak.developer.basic.myapplicationbackup.model2.response.UserApiResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserApiResponse>>

    @POST("users")
    suspend fun createUser(@Body user: UserApiRequest): Response<UserApiResponse>

    @PUT("users/{id}")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Body user: UserApiRequest
    ): Response<UpdateUserResponse>


}