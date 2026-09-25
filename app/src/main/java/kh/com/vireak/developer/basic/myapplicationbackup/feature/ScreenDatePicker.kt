package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import kh.com.vireak.developer.basic.myapplicationbackup.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



enum class DateFormat(val pattern: String){
    MONTH_DAY_YEAR("MM/dd/yyyy"),
    DAY_MONTH_YEAR("dd/MM/yyyy"),
    YEAR_MONTH_DAY("yyyy-MM-dd"),
    SHORT_DAY_MONTH_YEAR("EEE, MMM dd yyyy"),
    FULL_DAY_MONTH_YEAR("EEEE, MMMM dd yyyy"),
    DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    TIME_12_HOUR("hh:mm a")



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDatePicker(
    onDismiss: () -> Unit
){
    var showDatePicker by remember { mutableStateOf(false)}
    val datePickerState = rememberDatePickerState()


    val dateText = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(
            millis = it,
            dateFormat = DateFormat.MONTH_DAY_YEAR
        )
    }


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onDismiss
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


    ){padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {
            OutlinedTextField(
                modifier = Modifier.padding(18.dp),
                value = dateText?: "",
                onValueChange = {},
                readOnly = true,
                label = {
                    Modifier.padding(start = 60.dp)
                    Text(
                        text = "MM/DD/YY",
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showDatePicker = !showDatePicker
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_calender),
                            contentDescription = null
                        )
                    }
                }


            )
            if(showDatePicker){

                DatePicker(
                    modifier = Modifier.padding( 8.dp),
                    state = datePickerState,

                    colors = DatePickerDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedDayContentColor = Color.Blue,
//                    dayContentColor = Color.Red
                        todayContentColor = Color.Red,
                        selectedDayContainerColor = Color.Red,
                        todayDateBorderColor = Color.Red
                    )


                )


            }


        }



    }
}
fun convertMillisToDate(
    millis: Long,
    dateFormat: DateFormat
): String {
    val formatter = SimpleDateFormat(dateFormat.pattern, Locale.getDefault())
    return formatter.format(Date(millis))
}

@Preview(showBackground = false)
@Composable
fun ScreenDatePickerPreview(){
    ScreenDatePicker(
        onDismiss = {}
    )
}