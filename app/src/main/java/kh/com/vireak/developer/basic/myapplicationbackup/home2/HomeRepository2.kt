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
                id = 2,
                title = "Profile",
                description = "Click here to see Profile component",
                route = TestNavKey.Profile
            ),
            ComponentModel(
                id = 3,
                title = "Users",
                description = "Click here to see user list and search",
                route = TestNavKey.UserList
            ),
            ComponentModel(
                id = 4,
                title = "Chip",
                description = "Click here to see chip component",
                route = TestNavKey.Chip
            ),
            ComponentModel(
                id = 5,
                title = "Tabs",
                description = "Click here to see tabs component",
                route = TestNavKey.Tabs
            ),
            ComponentModel(
                id = 6,
                title = "Slider",
                description = "Click here to see slider component",
                route = TestNavKey.Slider
            ),
            ComponentModel(
                id = 7,
                title = "CheckBox",
                description = "Click here to see check box component",
                route = TestNavKey.CheckBox
            ),
            ComponentModel(
                id = 8,
                title = "SnackBar",
                description = "Click here to see snack bar component",
                route = TestNavKey.SnackBar
            ),
            ComponentModel(
                id = 9,
                title = "DatePicker",
                description = "Click here to see date picker component",
                route = TestNavKey.DatePicker
            ),
            ComponentModel(
                id = 10,
                title = "AlertDialog",
                description = "Click here to see alert dialog component",
                route = TestNavKey.AlertDialog
            ),
            ComponentModel(
                id = 11,
                title = "BottomSheet",
                description = "Click here to see bottom sheet component",
                route = TestNavKey.BottomSheet
            ),
            ComponentModel(
                id = 12,
                title = "RadioButton",
                description = "Click here to see radio button component",
                route = TestNavKey.RadioButton
            ),
            ComponentModel(
                id = 13,
                title = "FilledIconButton",
                description = "Click here to see filled icon button component",
                route = TestNavKey.FilledIconButton
            ),
            ComponentModel(
                id = 14,
                title = "NavigationBar",
                description = "Click here to see navigation bar component",
                route = TestNavKey.NavigationBar
            ),
            ComponentModel(
                id = 15,
                title = "NavigationDrawer",
                description = "Click here to see navigation drawer component",
                route = TestNavKey.NavigationDrawer
            ),
            ComponentModel(
                id = 16,
                title = "LoadingAndProgress",
                description = "Click here to see loading and progress component",
                route = TestNavKey.LoadingAndProgress
            ),
            ComponentModel(
                id = 17,
                title = "MultiChoiceSegmentedButton",
                description = "Click here to see multi choice segmented button component",
                route = TestNavKey.MultiChoiceSegmentedButton
            ),
            ComponentModel(
                id = 18,
                title = "SingleChoiceSegmentedButton",
                description = "Click here to see single choice segmented button component",
                route = TestNavKey.SingleChoiceSegmentedButton
            ),
            ComponentModel(
                id = 19,
                title = "HorizontalMultiBrowseCarousel",
                description = "Click here to see horizontal multi browse carousel component",
                route = TestNavKey.HorizontalMultiBrowseCarousel
            ),
            ComponentModel(
                id = 20,
                title = "Notification Permission",
                description = "Click here to see notification permission component",
                route = TestNavKey.NotificationPermission
            ),
            ComponentModel(
                id = 21,
                title = "User Api",
                description = "Basic request api feature before becoming a master coder",
                route = TestNavKey.UserApi
            )
        )
    }
}