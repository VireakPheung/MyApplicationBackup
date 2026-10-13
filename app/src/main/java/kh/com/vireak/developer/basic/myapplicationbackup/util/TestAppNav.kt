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
import kh.com.vireak.developer.basic.myapplicationbackup.feature.*
import kh.com.vireak.developer.basic.myapplicationbackup.feature.notificationpermission.NotificationPermissionScreen
import kh.com.vireak.developer.basic.myapplicationbackup.feature.userApi.ScreenUserApi

@Composable
fun TestApp() {
    val backStack = remember { mutableStateListOf<TestNavKey>(TestNavKey.Home) }
    val onBack = {
        if (backStack.size > 1) {
            backStack.removeLastOrNull()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        NavDisplay(
            backStack = backStack,
            onBack = onBack,
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
                        ScreenCard(onBack = onBack)
                    }
                    TestNavKey.Profile -> NavEntry(key) {
                        ProfileScreen(userId = 1, onBack = onBack)
                    }
                    TestNavKey.UserList -> NavEntry(key) {
                        UserListScreen(
                            onUserClick = { id -> backStack.add(TestNavKey.UserProfile(id)) }
                        )
                    }
                    is TestNavKey.UserProfile -> NavEntry(key) {
                        ProfileScreen(userId = key.userId, onBack = onBack)
                    }
                    TestNavKey.Chip -> NavEntry(key) { ScreenChip(onBack = onBack) }
                    TestNavKey.Tabs -> NavEntry(key) { ScreenTabs(onBack = onBack) }
                    TestNavKey.Slider -> NavEntry(key) { ScreenSlider(onBack = onBack) }
                    TestNavKey.CheckBox -> NavEntry(key) { ScreenCheckedBox(onBack = onBack) }
                    TestNavKey.SnackBar -> NavEntry(key) { ScreenSnackBar(onBack = onBack) }
                    TestNavKey.DatePicker -> NavEntry(key) { ScreenDatePicker(onDismiss = onBack) }
                    TestNavKey.AlertDialog -> NavEntry(key) { ScreenAlertDialog(onBack = onBack) }
                    TestNavKey.BottomSheet -> NavEntry(key) { ScreenBottomSheet(onBack = onBack) }
                    TestNavKey.RadioButton -> NavEntry(key) { ScreenRadioButton(onBack = onBack) }
                    TestNavKey.FilledIconButton -> NavEntry(key) { FilledIconButton(onBack = onBack) }
                    TestNavKey.NavigationBar -> NavEntry(key) { ScreenNavigationBar(onBack = onBack) }
                    TestNavKey.NavigationDrawer -> NavEntry(key) { ScreenNavigationDrawer(onBack = onBack) }
                    TestNavKey.LoadingAndProgress -> NavEntry(key) { ScreenLoadingAndProgress(onBack = onBack) }
                    TestNavKey.MultiChoiceSegmentedButton -> NavEntry(key) { ScreenMultiChoiceSegmentedButton(onBack = onBack) }
                    TestNavKey.SingleChoiceSegmentedButton -> NavEntry(key) { ScreenSingleChoiceSegmentedButton(onBack = onBack) }
                    TestNavKey.HorizontalMultiBrowseCarousel -> NavEntry(key) { ScreenHorizontalMultiBrowseCarousel(onBack = onBack) }
                    TestNavKey.NotificationPermission -> NavEntry(key) { NotificationPermissionScreen(onBack = onBack)}
                    TestNavKey.UserApi -> NavEntry(key) { ScreenUserApi(onBack = onBack)}
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
