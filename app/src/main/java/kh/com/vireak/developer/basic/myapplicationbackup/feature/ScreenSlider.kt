package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.annotation.RestrictTo
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSlider(){
    val sensitivityMap = remember {
        mutableStateMapOf(
            ScopeLevel.LEVEL_0 to 90f,
            ScopeLevel.LEVEL_1 to 80f,
            ScopeLevel.LEVEL_2 to 70f,
            ScopeLevel.LEVEL_3 to 60f,
            ScopeLevel.LEVEL_4 to 50f,
            ScopeLevel.LEVEL_6 to 40f,
            ScopeLevel.LEVEL_8 to 30f,
        )
    }
    var showSensitivity by remember {mutableStateOf(true)}

    val scopeList = listOf(
        SensitivityModel(
            label = "Camera Sensitivity", id = ScopeLevel.LEVEL_0,
        ),
        SensitivityModel(
            label = "Reddot", id = ScopeLevel.LEVEL_1,
        ),
        SensitivityModel(
            label = "Scope x2", id = ScopeLevel.LEVEL_2,
        ),
        SensitivityModel(
            label = "Scope x3", id = ScopeLevel.LEVEL_3,
        ),
        SensitivityModel(
            label = "Scope x4", id = ScopeLevel.LEVEL_4,
        ),
        SensitivityModel(
            label = "Scope x5", id = ScopeLevel.LEVEL_6,
        ),
        SensitivityModel(
            label = "Scope x6", id = ScopeLevel.LEVEL_8,
        ),

    )

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
                        text = "Screen Slider"
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
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                onClick = {
                    showSensitivity = !showSensitivity
                }
            ) {
                Text(
                    text = "Show Sensitivity",
                )
            }
        }
    ){padding ->


        Column(
            modifier = Modifier
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            if (showSensitivity){

                Text(
                    text = "Sensitivity",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                HorizontalDivider(
                    modifier = Modifier.padding(16.dp)
                )
                Column(
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth()
                ) {
                    scopeList.forEach { model ->
                        val value = sensitivityMap[model.id] ?: 50f

                        Row(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        ) {
                            Text(text = model.label, fontSize = 16.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = value.toInt().toString(), fontSize = 16.sp)
                        }
                        Slider(
                            valueRange = 0f..100f,
                            value = value,
                            onValueChange = { newValue ->
                                sensitivityMap[model.id] = newValue
                            }
                        )
                    }

                }
            }

        }



    }
}
data class SensitivityModel(
    val id: ScopeLevel,
    val label: String,
)
enum class ScopeLevel(code: String){
    LEVEL_0(code = "00"),
    LEVEL_1(code = "01"),
    LEVEL_2(code = "02"),
    LEVEL_3(code = "03"),
    LEVEL_4(code = "04"),
    LEVEL_6(code = "06"),
    LEVEL_8(code = "08")
}



@Preview(showBackground = false)
@Composable
fun ScreenSliderPreview(){
    ScreenSlider()
}