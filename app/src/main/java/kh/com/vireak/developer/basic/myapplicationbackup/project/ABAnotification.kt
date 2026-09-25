package kh.com.vireak.developer.basic.myapplicationbackup.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R

@OptIn(ExperimentalMaterial3Api::class)

data class Transaction(
    val merchant: String,
    val amount: Double,
    val account: String,
    val time: String,
    val date: String,
    val logo: Int
)
val transactionList = listOf(

    // 31 JUL 2026
    Transaction("Morning Cafe", 12000.0, "013 850 231", "8:10 AM", "31 JUL 2026", R.drawable.ic_store),
    Transaction("Fresh Mart", 35500.0, "013 850 231", "9:45 AM", "31 JUL 2026", R.drawable.ic_store),
    Transaction("Sky Laundry", 7000.0, "013 850 231", "11:20 AM", "31 JUL 2026", R.drawable.ic_store),
    Transaction("City Bakery", 9500.0, "013 850 231", "1:05 PM", "31 JUL 2026", R.drawable.ic_store),
    Transaction("Coffee Point", 14000.0, "013 850 231", "4:30 PM", "31 JUL 2026", R.drawable.ic_store),

    // 30 JUL 2026
    Transaction("Happy Noodles", 18000.0, "013 850 231", "8:30 AM", "30 JUL 2026", R.drawable.ic_store),
    Transaction("Blue Pharmacy", 27500.0, "013 850 231", "9:55 AM", "30 JUL 2026", R.drawable.ic_store),
    Transaction("Quick Print", 15000.0, "013 850 231", "11:15 AM", "30 JUL 2026", R.drawable.ic_store),
    Transaction("Sunrise Cafe", 9500.0, "013 850 231", "12:40 PM", "30 JUL 2026", R.drawable.ic_store),
    Transaction("Green Grocery", 42000.0, "013 850 231", "3:10 PM", "30 JUL 2026", R.drawable.ic_store),

    // 29 JUL 2026
    Transaction("Book Corner", 21000.0, "013 850 231", "9:05 AM", "29 JUL 2026", R.drawable.ic_store),
    Transaction("Tech Station", 98000.0, "013 850 231", "10:20 AM", "29 JUL 2026", R.drawable.ic_store),
    Transaction("Family Mart", 8500.0, "013 850 231", "12:55 PM", "29 JUL 2026", R.drawable.ic_store),
    Transaction("BBQ House", 56000.0, "013 850 231", "6:40 PM", "29 JUL 2026", R.drawable.ic_store),
    Transaction("Movie World", 30000.0, "013 850 231", "8:15 PM", "29 JUL 2026", R.drawable.ic_store),

    // 28 JUL 2026
    Transaction("Fresh Juice", 10000.0, "013 850 231", "7:45 AM", "28 JUL 2026", R.drawable.ic_store),
    Transaction("Stationery Hub", 22000.0, "013 850 231", "10:10 AM", "28 JUL 2026", R.drawable.ic_store),
    Transaction("Pizza Corner", 48000.0, "013 850 231", "1:35 PM", "28 JUL 2026", R.drawable.ic_store),
    Transaction("Laundry Express", 6000.0, "013 850 231", "4:20 PM", "28 JUL 2026", R.drawable.ic_store),
    Transaction("Mini Market", 19500.0, "013 850 231", "7:10 PM", "28 JUL 2026", R.drawable.ic_store),

    // 27 JUL 2026
    Transaction("Campus Cafe", 11000.0, "013 850 231", "8:25 AM", "27 JUL 2026", R.drawable.ic_store),
    Transaction("Fruit Market", 26500.0, "013 850 231", "10:45 AM", "27 JUL 2026", R.drawable.ic_store),
    Transaction("Ice Cream Bar", 9000.0, "013 850 231", "2:15 PM", "27 JUL 2026", R.drawable.ic_store),
    Transaction("Burger Time", 34000.0, "013 850 231", "5:50 PM", "27 JUL 2026", R.drawable.ic_store),
    Transaction("Night Coffee", 13000.0, "013 850 231", "8:30 PM", "27 JUL 2026", R.drawable.ic_store),

    // 26 JUL 2026
    Transaction("Fashion Shop", 75000.0, "013 850 231", "9:40 AM", "26 JUL 2026", R.drawable.ic_store),
    Transaction("Flower Garden", 16000.0, "013 850 231", "11:30 AM", "26 JUL 2026", R.drawable.ic_store),
    Transaction("Sushi Place", 68000.0, "013 850 231", "2:10 PM", "26 JUL 2026", R.drawable.ic_store),
    Transaction("Bike Service", 45000.0, "013 850 231", "5:15 PM", "26 JUL 2026", R.drawable.ic_store),
    Transaction("Late Night Mart", 12500.0, "013 850 231", "9:20 PM", "26 JUL 2026", R.drawable.ic_store)
)


@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp)
                    )
            ){
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(30.dp),
                    painter = painterResource(transaction.logo),
                    contentDescription = null,

                )
            }
            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = transaction.merchant,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${transaction.amount} KHR ចេញពីគណនី ${transaction.account}"
                )
            }

            Text(transaction.time)
        }

    }
}

@Composable
fun TransactionScreen(){
    LazyColumn {
        items(transactionList){transaction ->
            TransactionItem(transaction)

        }
    }
}
data class Promotion(
    val date: String,
    val image: Int,
    val title: String,
    val description: String
)

@Composable
fun PromotionCard(
    image: Int,
    title: String,
    description: String
){
    val pailinFont = FontFamily(
        Font(R.font.paiant_expanded_black)
    )
    val pailinFontLight = FontFamily(
        Font(R.font.pailiant_expanded_light)
    )
    val pailin_bold = FontFamily(
        Font(R.font.pailin_bold)
    )
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        ){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp),
            ) {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    color = Color.White,
                    fontFamily = pailin_bold,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(6f, 6f),
                            blurRadius = 2f
                        )
                    )
                )
                Text(
                    text = description,
                    fontSize =15.sp,
                    color = Color.White,
                    fontFamily = pailinFontLight,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 1f),
                            blurRadius = 4f
                        )
                    )
                )
            }

        }
    }


}
@Composable
fun PromotionScreen(){
    val promotions = listOf(
        Promotion(
            date = "21 JUL 2026",
            image = R.drawable.promo1,
            title = "បញ្ចុះតម្លៃពិសេសសម្រាប់អតិថិជនថ្មី",
            description = "បើកគណនីថ្មីថ្ងៃនេះ ដើម្បីទទួលបានការផ្តល់ជូន និងអត្ថប្រយោជន៍ជាច្រើន។"
        ),

        Promotion(
            date = "15 JUL 2026",
            image = R.drawable.promo2,
            title = "ទូទាត់តាម ABA ទទួលបាន Cashback",
            description = "ប្រើ ABA Scan QR ដើម្បីទូទាត់ និងទទួលបាន Cashback រហូតដល់ 10%។"
        ),

        Promotion(
            date = "08 JUL 2026",
            image = R.drawable.promo3,
            title = "ការផ្តល់ជូនពិសេសលើការទិញរថយន្ត",
            description = "ទទួលបានការបញ្ចុះតម្លៃ និងអត្រាការប្រាក់ទាបសម្រាប់ការទិញរថយន្តថ្មី។"
        ),

        Promotion(
            date = "29 JUN 2026",
            image = R.drawable.promotion5,
            title = "ផ្ទេរប្រាក់ឥតគិតថ្លៃ",
            description = "រីករាយជាមួយការផ្ទេរប្រាក់ទៅគណនី ABA ដោយមិនគិតថ្លៃសេវាកម្ម។"
        ),

        Promotion(
            date = "17 JUN 2026",
            image = R.drawable.promotion6,
            title = "បញ្ចុះតម្លៃសម្រាប់ការទិញទំនិញអនឡាញ",
            description = "ទូទាត់តាម ABA Card ឬ ABA KHQR ដើម្បីទទួលបានការបញ្ចុះតម្លៃនៅហាងដែលចូលរួម។"
        )

    )
    LazyColumn(

    ) {
        items(promotions) { promotion ->
            Text(
                text = promotion.date
            )
            PromotionCard(
                image = promotion.image,
                title = promotion.title,
                description = promotion.description
            )


            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ABANotification() {

    var selectedIndex by remember { mutableIntStateOf(2) }
    val option = listOf("ដំណឹងសំខាន់", "ប្រតិបត្តិការ", "សារជូនដំណឹង")

    val pailinFont = FontFamily(
        Font(R.font.paiant_expanded_black)
    )
    val pailinFontLight = FontFamily(
        Font(R.font.pailiant_expanded_light)
    )

    Scaffold(
        modifier = Modifier.background(
            color = Color.LightGray
        ),
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
//                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ),
                title = {
                    Text(
                        text = "Maynard សារជូនដំណឹង",
                        fontSize = 22.sp,
                        fontFamily = pailinFontLight,
                        color = Color.DarkGray,

                        )
                },


                )
        },
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
//            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .padding(padding),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally

            )
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp),

                        ) {

                        option.forEachIndexed { index, value ->
                            SegmentedButton(

                                selected = if (selectedIndex == index) true else false,
                                label = {
                                    Text(
                                        text = value
                                    )
                                },
                                onClick = {
                                    selectedIndex = index
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = SegmentedButtonDefaults.colors()
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ){
                        when(selectedIndex){
                            0 -> {
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(200.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(120.dp),
                                        painter = painterResource(R.drawable.nonoti),
                                        contentDescription = null
                                    )
                                    Text(
                                        modifier = Modifier.padding(top = 140.dp),
                                        text = "គ្មានការជូនដំណឹងសំខាន់",
                                        fontSize = 20.sp,
                                        fontFamily = pailinFontLight
                                    )
                                }

                            }

                            1 -> {
                                TransactionScreen()

                            }

                            2 -> {
                                PromotionScreen()
                            }


                        }

                    }


//            when(selectedIndex){
//                0 -> {
//                    Box(
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                            .size(200.dp)
//                            .background(
//                                color = Color.White,
//                                shape = RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp)
//                            ),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(120.dp),
//                            painter = painterResource(R.drawable.nonoti),
//                            contentDescription = null
//                        )
//                        Text(
//                            modifier = Modifier.padding(top = 140.dp),
//                            text = "គ្មានការជូនដំណឹងសំខាន់",
//                            fontSize = 20.sp,
//                            fontFamily = pailinFontLight
//                        )
//                    }
//
//                }
//
//                1 -> {
//
//                }
//
//            }
        }



    }
}



@Composable
@Preview(showBackground = false)
fun ABANotificationPreview() {
    ABANotification()
}

//Bad ui
