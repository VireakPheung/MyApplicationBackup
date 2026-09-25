package kh.com.vireak.developer.basic.myapplicationbackup.home2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.UserModel
import kh.com.vireak.developer.basic.myapplicationbackup.profile.UserRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UserVM(
    private val userRepository: UserRepository = UserRepository()
) : ViewModel(){
    private val _state = MutableStateFlow<BaseUiState<List<UserModel>>>(BaseUiState.Loading)
    var state = _state.asStateFlow()

    fun search(query: String){
        viewModelScope.launch {
            _state.value = BaseUiState.Loading
            userRepository.searchUser(query)
                .catch {_state.value = BaseUiState.Error(it.message ?: "Unknown error")}
                .collect{ _state.value = BaseUiState.Success(it)}
        }
    }

    init {
        search("")
    }

    fun onDispose(){
        viewModelScope.cancel()
        _state.value = BaseUiState.None
    }
}