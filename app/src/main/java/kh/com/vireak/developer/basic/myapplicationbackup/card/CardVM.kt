package kh.com.vireak.developer.basic.myapplicationbackup.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.ComponentModel
import kh.com.vireak.developer.basic.myapplicationbackup.test.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.log2

class CardVM(
    private val cardRepository: CardRepository = CardRepository()
) : ViewModel(){
    private val _state = MutableStateFlow<BaseUiState<List<ComponentModel>>>(BaseUiState.Loading)
    var state = _state.asStateFlow()


    fun load(){
        viewModelScope.launch {
            _state.value = BaseUiState.Loading
            try {
                val data = cardRepository.fetchData()
                _state.value = BaseUiState.Success(data)
            }catch (e: Exception){
                _state.value = BaseUiState.Error(e.message ?: "Unknown error")
            }

        }
    }
    init {
        load()
    }

}