package kh.com.vireak.developer.basic.myapplicationbackup.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProfileVM(
    private val userRepository: UserRepository = UserRepository()
) : ViewModel(){
    private val _state = MutableStateFlow<BaseUiState<UserModel>>(BaseUiState.Loading)
    val state = _state.asStateFlow()

    fun load(id: Int){
        viewModelScope.launch {
            _state.value = BaseUiState.Loading
            userRepository.getUserDetail(id)
                .catch { _state.value = BaseUiState.Error(it.message ?: "Unknown Error")}
                .collect { user ->
                    _state.value =
                        if(user != null) BaseUiState.Success(user)
                        else BaseUiState.Error("User not found")

                }
        }
    }
}