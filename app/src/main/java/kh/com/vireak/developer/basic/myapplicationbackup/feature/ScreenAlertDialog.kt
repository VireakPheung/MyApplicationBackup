package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import kh.com.vireak.developer.basic.myapplicationbackup.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAlertDialog(){
    var showAlertDialog by remember {mutableStateOf(true)}
    var showFullscreenDialog by remember { mutableStateOf(false)}
    val receiptText = "I LOVE YOUUUUUUU <333"

    val pailinFont = FontFamily(
        Font(R.font.paiant_expanded_black)
    )
    val pailinFontLight = FontFamily(
        Font(R.font.pailiant_expanded_light)
    )


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
                        text = "Screen Check Box"
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
            BottomAppBar(
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(9.dp)
                ){

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = {
                            showFullscreenDialog = true
                        }
                    ) {
                        Text(
                            text = "Fullscreen Dialog",
                            fontSize = 18.sp
                        )
                    }
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = {
                            showAlertDialog = true
                        }
                    ) {
                        Text(
                            text = "Alert Dialog",
                            fontSize = 18.sp
                        )
                    }



                }
            }
        }


    ){padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {

            if (showAlertDialog){

                AlertDialog(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray
                        ),
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_pflogo),
                            contentDescription = "Icon"
                        )
                    },
                    title = {
                        Text(
                            text = "DO YOU LOVE ME? :("
                        )
                    },
                    text = {
                        Text(
                            text = "I love you so very much, i could not calculate the love that i have for you so please think and choose the choice below >,<"
                        )
                    },
                    onDismissRequest = {
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showAlertDialog = false

                            }
                        ) {
                            Text("I love you too")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showAlertDialog = false
                            }
                        ) {
                            Text("Okay Babe")
                        }
                    }
                )
            }

            if (showFullscreenDialog){

                Dialog(
                    onDismissRequest = {
                        showFullscreenDialog = true
                    },

                    properties = DialogProperties(
                        usePlatformDefaultWidth = false
                    )


                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.background
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxSize()
                        ){

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(
                                    onClick =  {
                                        showFullscreenDialog = false
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_close),
                                        contentDescription = null
                                    )
                                }
                            }
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(R.drawable.img1),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .padding(top = 8.dp),
                                text = receiptText,
                                fontSize = 25.sp,
                                fontFamily = pailinFontLight
                            )

                            Spacer(modifier = Modifier.weight(1f))
                            Button(
                                modifier = Modifier.fillMaxWidth()
                                    .height(40.dp),
                                onClick = {
                                    showFullscreenDialog = false
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



    }
}


@Preview(showBackground = false)
@Composable
fun ScreenAlertDialogPreview(){
    ScreenAlertDialog()
}