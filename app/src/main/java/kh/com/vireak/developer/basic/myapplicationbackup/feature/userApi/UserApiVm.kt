package kh.com.vireak.developer.basic.myapplicationbackup.feature.userApi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.vireak.developer.basic.myapplicationbackup.model2.BaseUiState
import kh.com.vireak.developer.basic.myapplicationbackup.model2.request.UserApiRequest
import kh.com.vireak.developer.basic.myapplicationbackup.model2.response.UserApiResponse
import kh.com.vireak.developer.basic.myapplicationbackup.network.ApiService
import kh.com.vireak.developer.basic.myapplicationbackup.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class UserApiVm : ViewModel() {
    private val _userListUiState = MutableStateFlow<BaseUiState<List<UserApiResponse>>>(BaseUiState.None)
    val userListUiState = _userListUiState.asStateFlow()

    fun getUserList(){
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.instance.getUsers()
                if(response.isSuccessful){
                    val users = response.body()
                    if(users != null){
                        _userListUiState.value = BaseUiState.Success(users)
                    } else  {
                        _userListUiState.value = BaseUiState.Error("No user data found")
                    }
                }else{
                    _userListUiState.value = BaseUiState.Error("Request Failed: ${response.code()}")
                }

            }catch(e: Exception){
                _userListUiState.value = BaseUiState.ErrorWithException(e)
            }
        }

    }

    fun createUser(name: String, email: String){
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try{
                val response = RetrofitClient.instance.createUser(
                    UserApiRequest(name, email)
                )

                if (response.isSuccessful){
                    getUserList()
                }else {
                    _userListUiState.value = BaseUiState.Error(" ===> Create User Failed: ${response.code()}")
                }
            } catch (e: Exception){
                _userListUiState.value = BaseUiState.ErrorWithException(e)

            }
        }
    }

    fun updateUser(id: Int, name: String, email: String){
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try{
                val response = RetrofitClient.instance.updateUser(
                    id = id,
                    user = UserApiRequest(
                        name = name,
                        email = email
                    )
                )
                if (response.isSuccessful){
                    getUserList()
                }else{
                    _userListUiState.value = BaseUiState.Error(" ===> Update User Failed: ${response.code()}")
                }

            }catch (e: Exception){
                _userListUiState.value = BaseUiState.ErrorWithException(e)
            }
        }
    }
//    init{
//        getUserList()
//    }
}