package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.card.ScreenCard
import kh.com.vireak.developer.basic.myapplicationbackup.project.PromotionScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTabs(){
    val tabList = listOf<TabModel>(
        TabModel(label = "Overview", icon = R.drawable.ic_menu),
        TabModel(label = "Specifications", icon = R.drawable.ic_menu)
    )

    var selectedTabIndex by rememberSaveable{ mutableIntStateOf(0)} //rememberSaveable automatic reset to index 0




    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
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
                        text = "Screen Tabs"
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


    ){padding ->


        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryTabRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                selectedTabIndex = selectedTabIndex

            ) {
                tabList.forEachIndexed { index, model ->

                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(text = model.label)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(model.icon),
                                contentDescription = null
                            )
                        }

                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ){
                AnimatedContent(targetState = selectedTabIndex, label = "tabContent") { index ->
                    when (index) {
                        0 -> ScreenCard()
                        1 -> PromotionScreen()
                    }
                }
            }
        }



    }
}

data class TabModel(
    val label: String,
    @DrawableRes val icon: Int
)



@Preview(showBackground = false)
@Composable
fun ScreenTabsPreview(){
    ScreenTabs()
}