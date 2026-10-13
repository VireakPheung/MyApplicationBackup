package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.project.PromotionScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationBar(onBack: () -> Unit = {}){

    data class NavigationModel(
        val id: String,
        @DrawableRes val icon: Int,
        val label: String
    )
    var selectedId by remember {mutableStateOf("01")}

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
            icon = R.drawable.ic_setting,
            label = "Setting"
        ),


    )


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
                        text = "Navigation Bar"
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
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                navigationItem.forEach { item ->
                    NavigationBarItem(
                        onClick = {
                            selectedId = item.id
                        },
                        label = {
                            Text(
                                text = item.label
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.label
                            )
                        },
                        selected = selectedId == item.id,

                    )
                }

            }

        }



    ){padding ->

        Column(
            modifier = Modifier.padding(padding)

        ) {
            when(selectedId){

                "02" -> PromotionScreen()
            }






        }



    }
}



@Preview(showBackground = false)
@Composable
fun ScreenNavigationBarPreview(){
    ScreenNavigationBar()
}