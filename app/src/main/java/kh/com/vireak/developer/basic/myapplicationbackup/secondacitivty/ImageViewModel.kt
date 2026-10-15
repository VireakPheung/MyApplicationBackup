package kh.com.vireak.developer.basic.myapplicationbackup.secondacitivty

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    var uri: Uri? by mutableStateOf(null)
        private set

    fun updateUri(uri: Uri?){
        this.uri = uri
    }


}