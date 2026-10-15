package kh.com.vireak.developer.basic.myapplicationbackup.feature.notificationpermission

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.vireak.developer.basic.myapplicationbackup.network.ApiService
import kh.com.vireak.developer.basic.myapplicationbackup.network.RetrofitClient
import kotlinx.coroutines.launch


class NotificationVM (
    private val apiService: ApiService
) : ViewModel() {

    private val retrofitClient = RetrofitClient.instance


    fun getUserList(){
        viewModelScope.launch {

        }
    }


}