package kh.com.vireak.developer.basic.myapplicationbackup.feature

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.vireak.developer.basic.myapplicationbackup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenChip(
    onBack: () -> Unit = {}
){
    var selected by remember { mutableStateOf(false) }
    var enable by remember { mutableStateOf(true) }


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
                        text = "Screen Chip"
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
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssistChip(
                    onClick = { Log.d("Assist chip", "hello world")},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_calender),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "AssistChip"
                        )

                    }
                )
                Spacer(modifier = Modifier.width(8.dp))

                FilterChip(
                    onClick = {selected =!selected},
                    selected = selected,
                    leadingIcon = if (selected){
                        {
                            Icon(
                                painter = painterResource(R.drawable.ic_calender),
                                contentDescription = null
                            )
                        }
                    }else null,
                    label = {
                        Text(
                            text = "FilterChip"
                        )
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))

                if(enable){
                        InputChip(
                            onClick = {
                                enable = !enable
                            },
                            selected = enable,
                            label = {
                                Text(
                                    text = "Input Chip"
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_close),
                                    contentDescription = null
                                )
                            }
                        )
                }



            }
        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenChipPreview(){
    ScreenChip(
        onBack = {}
    )
}