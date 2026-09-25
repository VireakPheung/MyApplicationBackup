package kh.com.vireak.developer.basic.myapplicationbackup.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.UserModel
import kh.com.vireak.developer.basic.myapplicationbackup.util.LoadingUtil

@Composable
fun ProfileScreen(
    userId: Int,
    onBack: () -> Unit = {},
    vm: ProfileVM = viewModel()
) {
    val state by vm.state.collectAsState()
    LaunchedEffect(userId) { vm.load(userId) }
    LaunchedEffect(state) {
        when(state){
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            else -> LoadingUtil.hideLoading()
        }
    }

    when (val s = state) {
        is BaseUiState.Loading -> Box(Modifier.fillMaxSize(), Alignment.Center) {
        }
        is BaseUiState.Error -> Box(Modifier.fillMaxSize(), Alignment.Center) {
            Text(s.message)
        }
        is BaseUiState.Success -> ProfileContent(user = s.data, onBack = onBack)
        else -> {}
    }
}

@Composable
fun ProfileContent(
    user: UserModel,
    onBack: () -> Unit = {}
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Surface(
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 32.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        painter = painterResource(R.drawable.ic_backward_arrow),
                        contentDescription = null
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(210.dp),
                    colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Column(modifier = Modifier.padding(end = 16.dp)) {
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = user.name.uppercase(),
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = user.email,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = "ID: ${user.id}",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(160.dp)
                                .clip(RoundedCornerShape(78.dp))
                                .background(Color.DarkGray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img1),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ProfileScreenPreview() {
    ProfileContent(user = UserModel(1, "Vireak", "vireak@gmail.com"))
}