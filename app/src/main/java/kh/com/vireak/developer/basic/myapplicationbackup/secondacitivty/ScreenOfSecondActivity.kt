import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage

@Composable
fun ScreenOfSecondActivity(imageUri: Uri?) {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (imageUri != null){
                AsyncImage(
                    model = imageUri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = {
                    /*
                        swap screen normally here
                         */


//                    Intent(context, SecondActivity::class.java).also{
//                        context.startActivity(it)
//                    }

                    /*
                    Swap application to youtube
                     */

//                    Intent(Intent.ACTION_MAIN).also {
//
//                        try {
//                            context.startActivity(it)
//                        }catch (e: ActivityNotFoundException){
//                            e.printStackTrace()
//                        }
//                    }


                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("test@gmail.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "This is my subject")
                        putExtra(Intent.EXTRA_TEXT, "This is content of my email")
                    }
                    if (intent.resolveActivity(context.packageManager) != null){
                        context.startActivity(intent)
                    }

                }
                ) {
                    Text("Click Here")
                }
            }else {
                Button(
                    onClick = {
                        Intent(Intent.ACTION_MAIN).also {
                            it.`package` = "com.android.chrome"
                            try {
                                context.startActivity(it)
                            }catch (e: ActivityNotFoundException){
                                e.printStackTrace()
                            }
                        }
                    }
                ) {
                    Text("No Image Yet, Get in chrome")
                }
            }

        }
    }
}