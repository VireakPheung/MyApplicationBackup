package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenMultiChoiceSegmentedButton(){
    val selectedOption = remember { mutableStateListOf(false, false, false) }
    val options = listOf("Day", "Month", "Year" )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
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
                        text = "Multi Choice Segmented Button",
                        fontSize = 16.sp
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
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MultiChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
//                .padding(start = 100.dp)
            ) {
                options.forEachIndexed { index, value ->
                    SegmentedButton(
                        modifier = Modifier
                            .weight(1f)
                            .width(50.dp)
                            .height(50.dp),
                        checked = selectedOption[index],
                        shape = RoundedCornerShape(16.dp),
                        onCheckedChange = { isChecked ->
                            println(selectedOption)
                            println(isChecked)
                            selectedOption[index] = isChecked
                            println(selectedOption)

                        },
                        label = {
                            when(value){
                                "Day" ->
                                    Icon(
                                        painter = painterResource(R.drawable.ic_pflogo),
                                        contentDescription = null
                                    )
                                "Month" ->
                                    Icon(
                                        painter = painterResource(R.drawable.ic_calender),
                                        contentDescription = null
                                    )

                                "Year" ->
                                    Icon(
                                        painter = painterResource(R.drawable.ic_link),
                                        contentDescription = null
                                    )
                            }
                        }



                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenMultiChoiceSegmentedButtonPreview(){
    ScreenMultiChoiceSegmentedButton()
}
