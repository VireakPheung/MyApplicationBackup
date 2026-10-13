package kh.com.vireak.developer.basic.myapplicationbackup.util

import ScreenOfSecondActivity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.vireak.developer.basic.myapplicationbackup.home2.HomeScreen
import kh.com.vireak.developer.basic.myapplicationbackup.secondacitivty.ImageViewModel
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.MyApplicationBackupTheme
import java.time.LocalDateTime
import kotlin.getValue

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ImageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (savedInstanceState == null) handleIntent(intent)

        setContent {
            MyApplicationBackupTheme(){
//                if (LoadingUtil.isLoading.value){
//                    LoadingContent()
//                }
//
                /*
                Send Data between screen
                 */
                TestApp()


                /*
                Navigation 3
                 */
//                AppNavigation()

                /*
                Intent
                 */
//                ScreenOfSecondActivity(imageUri = viewModel.uri)



            }




//            MyApplicationBackupTheme {
//                if (LoadingUtil.isLoading.value) {
//                    LoadingContent()
//                }
//                  FilledIconButton()
//                  ScreenSingleChoiceSegmentedButton()
//                  ScreenMultiChoiceSegmentedButton()
//                  ABANotification()
//                    ScreenCard()
//                ScreenHorizontalMultiBrowseCarousel()
//                ScreenBottomSheet()
//                ScreenSlider()
//                ScreenSnackBar()
//                ScreenTabs()


        }

    }
    override fun onStart() {
        super.onStart()
        println("Main Activity ON_START")
    }

    override fun onPause() {
        super.onPause()
        println("Main Activity ON_PAUSE")
    }

    override fun onResume() {
        super.onResume()
        println("Main Activity ON_RESUME")
    }


    private fun handleIntent(intent: Intent?) {
        if (intent?.action != Intent.ACTION_SEND) return
        if (intent.type?.startsWith("image/") != true) return

        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Intent.EXTRA_STREAM)
        }
        viewModel.updateUri(uri)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }


}