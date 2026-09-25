package kh.com.vireak.developer.basic.myapplicationbackup.util

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import kh.com.vireak.developer.basic.myapplicationbackup.card.ScreenCard
import kh.com.vireak.developer.basic.myapplicationbackup.home2.HomeScreen

sealed class NavigationKey{
    data object HomeScreen : NavigationKey()
    data object ScreenCard: NavigationKey()
}

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<NavigationKey>(NavigationKey.HomeScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },

        /**
         * all of this above is animation or transition that is not so important to understand we can also copy automatic from somewhere else
         */

        // Animation for forward navigation (e.g. Home -> Card)
        transitionSpec = {
            // "this" here is AnimatedContentTransitionScope, which is what
            // lets us call slideInHorizontally/slideOutHorizontally with
            // access to the size of the content being animated.
            slideInHorizontally(
                animationSpec = tween(300),   // new screen takes 300ms to slide in
                initialOffsetX = { fullWidth -> fullWidth } // starts fully off-screen to the right
            ) togetherWith slideOutHorizontally(
                animationSpec = tween(300),   // old screen takes 300ms to slide out
                targetOffsetX = { fullWidth -> -fullWidth } // ends fully off-screen to the left
            )
        },

//         Animation for backward navigation (e.g. Card -> Home via onBack)
        popTransitionSpec = {
            slideInHorizontally(
                animationSpec = tween(300),
                initialOffsetX = { fullWidth -> -fullWidth } // comes back in from the left
            ) togetherWith slideOutHorizontally(
                animationSpec = tween(300),
                targetOffsetX = { fullWidth -> fullWidth } // exits to the right
            )
        },

        // Animation used specifically for the predictive-back gesture (Android 14+ swipe-back).
        // Reusing the same spec as popTransitionSpec keeps it consistent with onBack.
        predictivePopTransitionSpec = {
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
                NavigationKey.HomeScreen -> NavEntry(key) {
                    HomeScreen(
                        onClickItem = { route ->
                            if (route is NavigationKey) {
                                backStack.add(route)
                            }
                        }
                    )
                }

                NavigationKey.ScreenCard -> NavEntry(key) {
                    ScreenCard(
                        onBack = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }
            }

        },
    )

}
