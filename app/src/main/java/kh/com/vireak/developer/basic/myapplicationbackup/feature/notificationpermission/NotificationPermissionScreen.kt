package kh.com.vireak.developer.basic.myapplicationbackup.feature.notificationpermission

import android.Manifest
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.MyApplicationBackupTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationPermissionScreen(
    onBack: () -> Unit = {}
){

    val context = LocalContext.current

    var hasNotificationPermission by remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            mutableStateOf(
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            )
        } else mutableStateOf(true)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {isGranted ->
            hasNotificationPermission = isGranted
        },
    )

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

//    LaunchedEffect(permissionLauncher) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack

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
                        text = "Notification Permission"
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
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
                            contentDescription = ""
                        )
                    }


                }

            )

        },


    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {




            Button(
                onClick = {
                    if(hasNotificationPermission){
                        ShowNotification(context)
                    }
                }
            ) {
                Text("Request Notification")
            }

        }

    }

}




@Preview(showBackground = false)
@Composable
fun NotificationScreenPermissionPreview(){
    MyApplicationBackupTheme {
        NotificationPermissionScreen()
    }
}

