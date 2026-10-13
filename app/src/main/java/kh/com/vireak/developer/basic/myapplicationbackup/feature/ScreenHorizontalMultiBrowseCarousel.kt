package kh.com.vireak.developer.basic.myapplicationbackup.feature

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.vireak.developer.basic.myapplicationbackup.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHorizontalMultiBrowseCarousel(onBack: () -> Unit = {}){
    data class ItemModel(
        val id: Int,
        val title: String,
        @DrawableRes val image: Int
    )

    val listItem = listOf(
        ItemModel(
            id = 1,
            title = "Cute Little Puppy",
            image = R.drawable.img1
        ),
        ItemModel(
            id = 2,
            title = "Sleepy Orange Cat",
            image = R.drawable.img2
        ),
        ItemModel(
            id = 3,
            title = "Beautiful Mountain View",
            image = R.drawable.img3
        ),
        ItemModel(
            id = 4,
            title = "Fresh Green Forest",
            image = R.drawable.img4
        ),
        ItemModel(
            id = 5,
            title = "Colorful Sunset Beach",
            image = R.drawable.img5
        ),
        ItemModel(
            id = 6,
            title = "Modern City Skyline",
            image = R.drawable.img6
        )
    )
    val carouselState = rememberCarouselState(
        initialItem = 1,
        itemCount = { listItem.size }
    )

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
                        text = "Carousel"
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

        ) {
            HorizontalMultiBrowseCarousel(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth()
                    .height(230.dp),
                state = carouselState,
                preferredItemWidth = 186.dp
            ) { index ->
                val card = listItem[index]
                Image(
                    painter = painterResource(card.image),
                    contentDescription = card.title
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenHorizontalMultiBrowseCarouselPreview(){
    ScreenHorizontalMultiBrowseCarousel()
}
