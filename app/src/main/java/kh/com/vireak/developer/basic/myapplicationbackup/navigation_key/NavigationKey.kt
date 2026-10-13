package kh.com.vireak.developer.basic.myapplicationbackup.navigation_key

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed class TestNavKey {
    data object Home : TestNavKey()
    data object Card : TestNavKey()
    data object Profile : TestNavKey()

    data object UserList : TestNavKey()
    data class UserProfile(val userId: Int) : TestNavKey()

    data object Chip : TestNavKey()
    data object Tabs : TestNavKey()
    data object Slider : TestNavKey()
    data object CheckBox : TestNavKey()
    data object SnackBar : TestNavKey()
    data object DatePicker : TestNavKey()
    data object AlertDialog : TestNavKey()
    data object BottomSheet : TestNavKey()
    data object RadioButton : TestNavKey()
    data object FilledIconButton : TestNavKey()
    data object NavigationBar : TestNavKey()
    data object NavigationDrawer : TestNavKey()
    data object LoadingAndProgress : TestNavKey()
    data object MultiChoiceSegmentedButton : TestNavKey()
    data object SingleChoiceSegmentedButton : TestNavKey()
    data object HorizontalMultiBrowseCarousel : TestNavKey()
    data object NotificationPermission : TestNavKey ()

    data object UserApi : TestNavKey()
}