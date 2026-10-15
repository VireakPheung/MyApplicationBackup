package kh.com.vireak.developer.basic.myapplicationbackup.secondacitivty

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import android.net.Uri
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.MyApplicationBackupTheme
import kotlin.jvm.java

class SecondActivity : ComponentActivity() {

    private val viewModel by viewModels<ImageViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationBackupTheme() {
                Text("Second Activity")
            }
        }
    }




}