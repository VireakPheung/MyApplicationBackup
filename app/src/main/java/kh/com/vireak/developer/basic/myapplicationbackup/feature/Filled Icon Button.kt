package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun FilledIconButton(onBack: () -> Unit = {}){
    var text by remember{ mutableStateOf(value = "https://vireakdeveloper.net") }
    var isChecked by remember{ mutableStateOf(false)}
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
                        text = "Filled Icon Button"
                    )
                },
                actions = {
                    IconButton(
                        onClick = {}
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
            Button(
                modifier = Modifier
                    .height(56.dp)
                    .width(250.dp),
                onClick = {
                    text = "https://vireakpheung.dev.net"
                },
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_link),
                        contentDescription = ""
                    )
                    Text(
                        text = "Show The Link"
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            FilledTonalButton(
                modifier = Modifier
                    .height(56.dp)
                    .width(250.dp),
                onClick = {
                    text = ""
                },
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_pflogo),
                        contentDescription = ""
                    )

                    Text(
                        text = "Hide The Link"
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            FilledTonalIconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_pflogo),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            FilledTonalIconToggleButton(
                checked = isChecked,
                onCheckedChange = {value ->
                    isChecked = value
                },
                colors = IconButtonDefaults.filledIconToggleButtonColors()
            ) {
                if (isChecked){
                    Icon(
                        painter = painterResource(R.drawable.ic_check),
                        contentDescription = null
                    )

                }


            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = {},
                shape = ButtonDefaults.outlinedShape

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_morevert),
                    contentDescription = null
                )
                Text(
                    text = "Menu"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            ElevatedButton(
                onClick = {},

            ) {
                Text(
                    text = "OK"
                )

            }

            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Hello Brother"
                )
            }

        }

    }
}

@Preview(showBackground = false)
@Composable
fun FilledIconButtonPreview(){
    FilledIconButton()
}
