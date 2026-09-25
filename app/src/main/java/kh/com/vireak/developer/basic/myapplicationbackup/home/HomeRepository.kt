//package kh.com.vireak.developer.basic.myapplicationbackup.home
//
//import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
//import kh.com.vireak.developer.basic.myapplicationbackup.util.NavigationKey
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.Flow
//
//class HomeRepository {
//    val componentList = listOf(
//        ComponentModel(
//            id = 1,
//            title = "Card",
//            description = "Click here to see card component",
//            route = NavigationKey.ScreenCard
//        )
//    )
//
//    suspend fun getComponentList(): Flow<List<ComponentModel>> {
//        delay(2000)
//
//        throw Exception("Error Network request")
//
//    }
//
//
//}