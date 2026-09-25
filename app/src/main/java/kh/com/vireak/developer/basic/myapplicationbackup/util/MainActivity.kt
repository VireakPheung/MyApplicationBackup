package kh.com.vireak.developer.basic.myapplicationbackup.util

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.com.vireak.developer.basic.myapplicationbackup.ui.theme.MyApplicationBackupTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    private val currentDateTime = LocalDateTime.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Main Activity onCreate $currentDateTime")
        enableEdgeToEdge()
        setContent {
            MyApplicationBackupTheme(){
                if (LoadingUtil.isLoading.value){
                    LoadingContent()
                }

                TestApp()


//                AppNavigation()


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

    override fun onDestroy() {
        super.onDestroy()
        println("Main Activity ON_DESTROY $currentDateTime")
    }


}