package kh.com.vireak.developer.basic.myapplicationbackup.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object TestLoadingUtil{
    var isLoading = mutableStateOf(false)
        private set
    fun showLoading(){
        isLoading.value = true
    }
    fun hideLoading(){
        isLoading.value = false
    }
}
sealed class UiState<out T>{
    data object Loading: UiState<Nothing>()
    data class Success<out T>(val data: T): UiState<T>()
    data class Error(val message: String): UiState<Nothing>()
}


class TestRepository{
    suspend fun fetchData(): String{
        delay(2000)
        throw Exception("Network request is failed")

    }
}

class TestLoaderVM(
    private val repository: TestRepository = TestRepository()
): ViewModel(){

    private val _state = MutableStateFlow<UiState<String>>(UiState.Loading)
    var state = _state.asStateFlow()

     fun load(){
         viewModelScope.launch {
             _state.value = UiState.Loading
             try{
                 val data = repository.fetchData()
                 _state.value = UiState.Success(data)

             }catch (e: Exception){
                 _state.value = UiState.Error(e.message ?: "Unknown error")
             }

         }
    }

    init{
        load()
    }
}
@Composable
fun TestLoadingScreen(vm: TestLoaderVM = viewModel()){
    val state by vm.state.collectAsState()

    LaunchedEffect(state) {
        when (state){
            is UiState.Loading -> TestLoadingUtil.showLoading()
            else -> TestLoadingUtil.hideLoading()
        }
    }


    Scaffold(

    ) {paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(val s = state){
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }
                is UiState.Success -> {
                    Text(text = s.data)
                }
                is UiState.Error -> {
                    Text(text = "Error: ${s.message}")
                }
            }

        }



    }

}

@Composable
fun TestApp(){
    Box(modifier = Modifier.fillMaxSize()){
        TestLoadingScreen()
        if(TestLoadingUtil.isLoading.value){
            Dialog(onDismissRequest = {}){
                Surface(color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f)) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
fun TestLoadingPreview(){
    TestApp()
}
