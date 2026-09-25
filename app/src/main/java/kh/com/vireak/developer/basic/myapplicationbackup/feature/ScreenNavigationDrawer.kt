package kh.com.vireak.developer.basic.myapplicationbackup.feature

import android.graphics.Paint
import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastCbrt
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.navigationevent.compose.rememberNavigationEventState
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.project.PromotionScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




data class NavigationModelDrawer(
    val label: String,
    val id: String
)
val drawerItem = listOf<NavigationModelDrawer>(
    NavigationModelDrawer(id = "01", label =  "Home Page"),
    NavigationModelDrawer(id = "02", label = "Support Center"),
    NavigationModelDrawer(id = "03", label = "Setting"),
    NavigationModelDrawer(id = "04", label = "Contact Us"),
    NavigationModelDrawer(id = "05", label = "Privacy and Security"),
    NavigationModelDrawer(id = "06", label = "Rate Us"),
)
data class SettingToggleItem(
    val label: String,
    val checked: Boolean,
    val onCheckChange: (Boolean) -> Unit,
    @DrawableRes var icon: Int
)
@Composable
fun SettingSectionTitle(title: String){
    Text(
        text = title,
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, bottom = 4.dp),
        color = MaterialTheme.colorScheme.primary
    )
}
@Composable
fun SettingToggleRow(item: SettingToggleItem){
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = item.label, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = item.checked,
                onCheckedChange = item.onCheckChange
            )
        }
        HorizontalDivider()
    }
}

@Composable
fun SettingScreen(){
    var wifiEnabled by remember{ mutableStateOf(true)}
    var mobiledataEnabled by remember { mutableStateOf(false) }
    var airplaneEnabled by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }
    var notificationEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        SettingSectionTitle(title = "Network")
        SettingToggleRow(
            SettingToggleItem(
                label = "Wi-Fi",
                icon = R.drawable.ic_wifi,
                checked = wifiEnabled,
                onCheckChange = { wifiEnabled = it}

            )

        )
        SettingToggleRow(
            SettingToggleItem(
                label = "Calcular Data",
                icon = R.drawable.ic_mobile_data,
                checked = mobiledataEnabled,
                onCheckChange = { mobiledataEnabled = it}

            )

        )
        SettingToggleRow(
            SettingToggleItem(
                label = "Airplane Mode",
                icon = R.drawable.ic_airplanemode,
                checked = airplaneEnabled,
                onCheckChange = { airplaneEnabled = it}

            )

        )
        SettingSectionTitle(title = "Preference")
        SettingToggleRow(
            SettingToggleItem(
                label = "Dark Mode",
                icon = R.drawable.ic_darkmode,
                checked = darkMode,
                onCheckChange = { darkMode = it}

            )

        )
        SettingToggleRow(
            SettingToggleItem(
                label = "Notification",
                icon = R.drawable.ic_notification,
                checked = notificationEnabled,
                onCheckChange = { notificationEnabled = it}

            )

        )

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationDrawer(){
    var isDrawerContentActive by remember {mutableStateOf(false)}
    var selectedId by remember{mutableStateOf("01")}
    var selectedNavId by remember {mutableStateOf(value = "03")}

    var loading by remember {mutableStateOf(false)}

    val pailinFont = FontFamily(
        Font(R.font.paiant_expanded_black)
    )
    val pailinFontLight = FontFamily(
        Font(R.font.pailiant_expanded_light)
    )
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    data class NavigationModel(
        val id: String,
        @DrawableRes val icon: Int,
        val label: String
    )

    var navigationItem = listOf<NavigationModel>(
        NavigationModel(
            id = "01",
            icon = R.drawable.ic_home2,
            label = "Home"
        ),
        NavigationModel(
            id = "02",
            icon = R.drawable.ic_notification,
            label = "Notification"
        ),
        NavigationModel(
            id = "03",
            icon = R.drawable.ic_menu,
            label = "Menu"
        ),


    )

    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                windowInsets = WindowInsets(0)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .height(64.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(0.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Navigation Drawer",
                        fontSize = 18.sp
                    )
                }
                HorizontalDivider()

                drawerItem.forEach { item ->

                    NavigationDrawerItem(
//        modifier = Modifier.background(color = Color.LightGray, shape = RoundedCornerShape(0.dp)),
                        shape = RoundedCornerShape(0.dp),
                        selected = selectedId == item.id,
                        label = {
                            Text(
                                text = item.label
                            )
                        },
                        onClick = {
                            selectedId = item.id
                            isDrawerContentActive = true
                            scope.launch { drawerState.close() }
                        }

                    )
                    HorizontalDivider()



                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                selectedId = "01"
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_backward_arrow),
                                contentDescription = "Back",
                            )
                        }

                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            text = "Navigation Bar",
                            fontSize = 24.sp
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = {
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_calender),
                                contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_pflogo),
                                contentDescription = ""
                            )
                        }


                    }

                )

            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    navigationItem.forEach { item2, ->
                        NavigationBarItem(
                            onClick = {
                                if (item2.id == "03"){
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                                isDrawerContentActive = false
                                selectedNavId = item2.id
                            },
                            label = {
                                Text(
                                    text = item2.label
                                )
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(item2.icon),
                                    contentDescription = item2.label
                                )
                            },
                            selected = selectedNavId == item2.id,

                            )
                    }

                }

            }

        ){padding ->

            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                if (isDrawerContentActive){

                    when(selectedId){
                        "01" -> {

                            Text(
                                text = "HOME SCREEN"
                            )
                        }
                        "02" -> {
                            Text(
                                text = "SUPPORT CENTER"
                            )
                        }
                        "03" -> {
                            SettingScreen()
                        }
                        "04" -> {
                            Text(
                                text = "CONTACT US"
                            )
                        }
                        "05" -> {
                            Text(
                                text = "PRIVACY AD SECURITY"
                            )
                        }
                        "06" -> {
                            Text(
                                text = "RATE US"
                            )
                        }

                    }
                }else{
                    when(selectedNavId){
                        "01" -> {
                            Text(
                                text = "NavBar Home Screen"
                            )
                        }
                        "02" -> {
                            PromotionScreen()
                        }
                        "03" -> {
                            Text(
                                text = "NavBar Setting"
                            )
                        }
                    }
                }


            }



        }
    }
}





@Preview(showBackground = false)
@Composable
fun ScreenNavigationDrawerPreview(){
    ScreenNavigationDrawer()
}