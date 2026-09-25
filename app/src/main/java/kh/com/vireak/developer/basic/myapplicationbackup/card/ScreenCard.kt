package kh.com.vireak.developer.basic.myapplicationbackup.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model.CardViewModel
import kh.com.vireak.developer.basic.myapplicationbackup.navigation_key.TestNavKey
import kh.com.vireak.developer.basic.myapplicationbackup.util.LoadingUtil


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenCard(
    cardVM: CardVM = viewModel(),
    onBack: () -> Unit = {},
){
    var product by remember{

        mutableStateOf(
            ProductModel(
                id = "0001",
                productName = "ICE AMERICANO",
                price = 2.5,
                switch = "COLD NICE FRESH MORNING",
                orderCount = 0,
                image = R.drawable.pic_aula2
            )
        )
    }
    val state by cardVM.state.collectAsState()

    LaunchedEffect(state) {
        when (state) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }
            else -> LoadingUtil.hideLoading()
        }
    }

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
                        text = "Screen Card"
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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(140.dp),
                    shape = RoundedCornerShape(8.dp)

            ){
                when(val s = state){
                    is BaseUiState.Loading ->{}
                    is BaseUiState.Success -> Text(s.data.toString())
                    is BaseUiState.Error -> Text("Error: ${s.message}")
                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding( 16.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                ){
//
//                    Box(
//                        modifier = Modifier
////                            .padding(16.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                            .size(120.dp)
//
//                            .background(
//                                color = MaterialTheme.colorScheme.secondary
//                            ),
//
//
//                        contentAlignment = Alignment.Center
//
//                    ){
//                        Image(
//                            painter = painterResource(R.drawable.ice_americano),
//                            contentDescription = ""
//                        )
//                    }
//
//                    Column(
//                        modifier = Modifier
//                            .padding(start = 8.dp)
//                            .weight(1f)
//
//                    ) {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                modifier = Modifier.weight(1f),
//                                text = product.productName,
//                                fontSize = 14.sp
//                            )
//                            IconButton(
//                                onClick = {
//                                    product.orderCount == 0
//                                    print(product.orderCount)
//                                }
//                            ) {
//                                Icon(
//                                    modifier = Modifier.size(20.dp),
//                                    painter = painterResource(R.drawable.ic_delete),
//                                    contentDescription = null,
//
//                                )
//                            }
//
//
//                        }
//                        Text(
//
//                            text = product.switch,
//                            fontSize = 12.sp
//                        )
////                        Text(
////
////                            text = "ICE/HOT",
////                            fontSize = 12.sp
////                        )
////                        Spacer(modifier = Modifier.height(1f))
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                modifier = Modifier.weight(1f),
//                                text = "$${product.price}",
//                                fontSize = 16.sp
//                            )
//                            IconButton(
//                                onClick = {
//                                    if(product.orderCount > 0){
//                                        product = product.copy(orderCount = product.orderCount - 1)
//                                    }
//                                }
//                            ) {
//                                Icon(
//                                    modifier = Modifier.size(12.dp),
//                                    painter = painterResource(R.drawable.ic_minus),
//                                    contentDescription = null,
//
//                                    )
//                            }
//                            Text(
////                                modifier = Modifier.weight(1f),
//                                text = "${product.orderCount}",
//                                fontSize = 16.sp,
//                                textAlign = TextAlign.Center
//                            )
//                            IconButton(
//                                onClick = {
//                                        product = product.copy(orderCount = product.orderCount + 1)
//                                }
//                            ) {
//                                Icon(
//                                    modifier = Modifier.size(14.dp),
//                                    painter = painterResource(R.drawable.ic_add),
//                                    contentDescription = null,
//
//                                    )
//                            }
//
//                        }
//                    }
//                }
            }

            Button(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                onClick = onBack
            ) {
                Text("Go Back To Home Screen")
            }


        }

    }
}


@Preview(showBackground = false)
@Composable
fun ScreenCardPreview(){
    ScreenCard()
}

data class ProductModel(
    val id: String,
    val productName: String,
    val price: Double,
    val switch: String,
    var orderCount: Int,
    @DrawableRes val image: Int
)



