package kh.com.vireak.developer.basic.myapplicationbackup.profile
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.home2.UserVM
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.util.LoadingUtil

@Composable
fun UserListScreen(
    onUserClick: (Int) -> Unit,
    vm: UserVM = viewModel()
){
    val state by vm.state.collectAsState()
    var query by remember { mutableStateOf("") }

    LaunchedEffect(state) {
        when (state) {
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            else -> LoadingUtil.hideLoading()
        }
    }


    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                vm.search(it)
            },
            label = { Text("Search user") },
            modifier = Modifier.fillMaxWidth()
        )

        when (val s = state) {
            is BaseUiState.Loading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {}
            is BaseUiState.Error -> Text(s.message)
            is BaseUiState.Success -> LazyColumn {
                items(s.data) { user ->
                    Text(
                        text = user.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onUserClick(user.id) }
                            .padding(16.dp)
                    )
                }
            }
            else -> {}
        }
    }

}