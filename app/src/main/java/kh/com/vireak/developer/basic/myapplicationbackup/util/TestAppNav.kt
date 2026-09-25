package kh.com.vireak.developer.basic.myapplicationbackup.util

import kh.com.vireak.developer.basic.myapplicationbackup.profile.UserListScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import kh.com.vireak.developer.basic.myapplicationbackup.card.ScreenCard
import kh.com.vireak.developer.basic.myapplicationbackup.home2.HomeScreen
import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey
import kh.com.vireak.developer.basic.myapplicationbackup.profile.ProfileScreen

@Composable
fun TestApp() {
    val backStack = remember { mutableStateListOf<TestNavKey>(TestNavKey.Home) }

    Box(modifier = Modifier.fillMaxSize()) {
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) {
                    backStack.removeLastOrNull()
                }
            },
            transitionSpec = {
                slideInHorizontally(
                    animationSpec = tween(300),
                    initialOffsetX = { fullWidth -> fullWidth }
                ) togetherWith slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { fullWidth -> -fullWidth }
                )
            },
            popTransitionSpec = {
                slideInHorizontally(
                    animationSpec = tween(300),
                    initialOffsetX = { fullWidth -> -fullWidth }
                ) togetherWith slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { fullWidth -> fullWidth }
                )
            },
            entryProvider = { key ->
                when (key) {
                    TestNavKey.Home -> NavEntry(key) {
                        HomeScreen(
                            onClickItem = { route -> backStack.add(route) }
                        )
                    }
                    TestNavKey.Card -> NavEntry(key) {
                        ScreenCard(
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            }
                        )
                    }
                    TestNavKey.Profile -> NavEntry(key) {
                        ProfileScreen(
                            userId = 1,
                            onBack = {

                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            }
                        )
                    }
                    TestNavKey.UserList -> NavEntry(key) {
                        UserListScreen(
                            onUserClick = { id -> backStack.add(TestNavKey.UserProfile(id)) }
                        )
                    }
                    is TestNavKey.UserProfile -> NavEntry(key) {
                        ProfileScreen(
                            userId = key.userId,
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            }
                        )
                    }


                }
            }
        )

        if (LoadingUtil.isLoading.value) {
            LoadingContent()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TestAppPreview() {
    TestApp()
}
