package kh.com.vireak.developer.basic.myapplicationbackup.model2.request

import kotlinx.serialization.Serializable


@Serializable
data class UserApiRequest(
    val name: String,
    val email: String,
)