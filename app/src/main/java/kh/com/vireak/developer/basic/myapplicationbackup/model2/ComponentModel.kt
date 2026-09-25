package kh.com.vireak.developer.basic.myapplicationbackup.model2

import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey

data class ComponentModel(
    val id: Int,
    val description: String,
    val title: String,
    val route: TestNavKey,
)