package kh.com.vireak.developer.basic.myapplicationbackup.profile

import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
import kh.com.vireak.developer.basic.myapplicationbackup.model2.UserModel
import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository {
    val userList = listOf(
        UserModel(
            id = 1,
            name = "Vireak",
            email = "vireak@gmail.com"
        ),
        UserModel(
            id = 2,
            name = "Dara",
            email = "dara@gmail.com"
        ),
        UserModel(
            id = 3,
            name = "Sokha",
            email = "sokha@gmail.com"
        ),
        UserModel(
            id = 4,
            name = "Bora",
            email = "bora@gmail.com"
        )
    )

    fun searchUser(query: String): Flow<List<UserModel>> = flow {
        delay(1000)
        emit(userList.filter {it.name.contains(query, ignoreCase = true)})
    }

    fun getUserDetail(id: Int): Flow<UserModel?> = flow {
        delay(1000)
        emit(userList.firstOrNull { it.id == id})
    }


}