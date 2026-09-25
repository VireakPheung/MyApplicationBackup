package kh.com.vireak.developer.basic.myapplicationbackup.model

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState

class CardViewModel : ViewModel() {
    private var _messageUiState: MutableStateFlow<BaseUiState<String>> = MutableStateFlow(
        BaseUiState.None)
    val messageUiState = _messageUiState.asStateFlow()

    fun requestData(){
        viewModelScope.launch {
            _messageUiState.value = BaseUiState.Loading
            delay(3000)
            _messageUiState.value = BaseUiState.Success("This is a message from server")

        }

//        Make Network Request
    }
}