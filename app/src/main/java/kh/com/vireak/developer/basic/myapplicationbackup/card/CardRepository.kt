package kh.com.vireak.developer.basic.myapplicationbackup.card

import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey
import kh.com.vireak.developer.basic.myapplicationbackup.util.NavigationKey
import kotlinx.coroutines.delay

class CardRepository{
    suspend fun fetchData(): List<ComponentModel>{
        delay(2000)
        return listOf(
            ComponentModel(
                id = 1,
                title = "Home",
                description = "Click here to see home screen",
                route = TestNavKey.Home
            )

        )
    }
}