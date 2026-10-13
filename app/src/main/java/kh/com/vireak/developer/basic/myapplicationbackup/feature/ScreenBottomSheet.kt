package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.card.ScreenCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomSheet(onBack: () -> Unit = {}){
    var showBottomSheet by remember{mutableStateOf(false)}
    var showRecipt by remember { mutableStateOf(false)}
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

    var sizeSelectedOption by remember { mutableStateOf(1)}
    var sugarSelectedOption by remember { mutableStateOf(1)}

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (showRecipt) {
                                showRecipt = false
                            } else {
                                onBack()
                            }
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
                        text = "Bottom Sheet"
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
                onClick =   {
                    showBottomSheet = true
                }
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
            if (!showRecipt){
                ScreenCard()
            }
            if (showRecipt){
                ReciptSection(
                    sugar = sugarList[sugarSelectedOption],
                    size = sizeList[sizeSelectedOption]
                )
            }

            if(showBottomSheet){

                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    }
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
                                    sizeSelectedOption = index
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
                                    sugarSelectedOption = index
                                },
                                selected = (index == sugarSelectedOption)
                            )
                            Text(
                                text = model.label,
                                fontSize = 16.sp
                            )

                        }
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            showBottomSheet = false
                            showRecipt = true
                        }
                    ) {
                        Text(
                            text = "Confirm"
                        )
                    }

                }
            }
        }



    }
}

@Composable
fun ReciptSection(size: SizeModel, sugar: SugarModel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Your Order",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Size: ${size.label}", fontSize = 16.sp)
            Text(text = "Sugar: ${sugar.label}", fontSize = 16.sp)

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Thank You! ",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                text = "Your order has been confirmed",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenBottomSheetPreview(){
    ScreenBottomSheet()
}