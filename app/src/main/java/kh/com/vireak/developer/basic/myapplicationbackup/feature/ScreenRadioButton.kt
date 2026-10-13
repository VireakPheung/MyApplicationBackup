package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadioButton(onBack: () -> Unit = {}){
    val sizeList = listOf(
        SizeModel(id = Size.SMALL, label = "Small"),
        SizeModel(id = Size.MEDIUM, label = "Medium"),
        SizeModel(id = Size.LARGE, label = "Large"),
        SizeModel(id = Size.EXTRA_LARGE, label = "Extra_Large"),
    )

    val sugarList = listOf(
        SugarModel(id = Sugar.LEVEL_0, label = "No Sugar"),
        SugarModel(id = Sugar.LEVEL_25, label = "25%"),
        SugarModel(id = Sugar.LEVEL_50, label = "50%"),
        SugarModel(id = Sugar.LEVEL_75, label = "75%"),
        SugarModel(id = Sugar.LEVEL_100, label = "100%")
    )

    val (sizeSelectedOption, sizeSelectedIndex) = remember {mutableIntStateOf(1)}
    val (sugarSelectedOption, sugarSelectedIndex) = remember {mutableIntStateOf(1)}

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
                        text = "Radio Button"
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
                onClick =   {}
            ) {
                Text(
                    text = "Order Now",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }



    ){padding ->

        Column(
            modifier = Modifier.padding(padding)

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Size Selection",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            sizeList.forEachIndexed {index, model ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        onClick = {
                            sizeSelectedIndex(index)
                        },
                        selected = (index == sizeSelectedOption)
                    )
                    Text(
                        text = model.label,
                        fontSize = 16.sp
                    )

                }
            }

            HorizontalDivider()
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Sugar Selection",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            sugarList.forEachIndexed {index, model ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        onClick = {
                            sugarSelectedIndex(index)
                        },
                        selected = (index == sugarSelectedOption)
                    )
                    Text(
                        text = model.label,
                        fontSize = 16.sp
                    )

                }
            }
        }



    }
}

//Size Item
data class SizeModel(
    var selected: Boolean = true,
    val id: Size,
    val enable: Boolean = false,
    val label: String
)

enum class Size(code: String){
    SMALL("01"),
    MEDIUM("02"),
    LARGE("03"),
    EXTRA_LARGE("04")
}
//sugar item
data class SugarModel(
    var selected: Boolean = true,
    val id: Sugar,
    val enable: Boolean = false,
    val label: String
)
enum class Sugar(code: String){
    LEVEL_0("00"),
    LEVEL_25("25"),
    LEVEL_50("50"),
    LEVEL_75("75"),
    LEVEL_100("100"),
}


@Preview(showBackground = false)
@Composable
fun ScreenRadioButtonPreview(){
    ScreenRadioButton()
}
