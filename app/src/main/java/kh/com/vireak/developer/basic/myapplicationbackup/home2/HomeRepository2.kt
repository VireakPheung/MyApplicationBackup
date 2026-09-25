package kh.com.vireak.developer.basic.myapplicationbackup.home2

import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey
import kotlinx.coroutines.delay

class HomeRepository2 {
    suspend fun fetchData(): List<ComponentModel> {
        delay(2000)
        return listOf(
            ComponentModel(
                id = 1,
                title = "Card",
                description = "Click here to see card component",
                route = TestNavKey.Card
            ),

            ComponentModel(
                id = 1,
                title = "Profile",
                description = "Click here to see Profile component",
                route = TestNavKey.Profile
            ),

            ComponentModel(
                id = 3,
                title = "Users",
                description = "Click here to see user list and search",
                route = TestNavKey.UserList
            )
        )
    }
}