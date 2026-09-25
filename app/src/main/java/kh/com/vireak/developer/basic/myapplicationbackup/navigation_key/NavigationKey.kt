package kh.com.vireak.developer.basic.myapplicationbackup.navigation_key

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed class TestNavKey {
    data object Home : TestNavKey()
    data object Card : TestNavKey()
    data object Profile : TestNavKey()

    data object UserList : TestNavKey()
    data class UserProfile(val userId: Int) : TestNavKey()
}