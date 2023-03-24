package com.example.RaihanAnhar203040113

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.RaihanAnhar203040113.scanners.PengelolaanPendaftaranawalGym
import com.example.RaihanAnhar203040113.ui.theme.RaihanAnhar203040113Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaihanAnhar203040113Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PengelolaanPendaftaranawalGym()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RaihanAnhar203040113Theme {
        PengelolaanPendaftaranawalGym()
    }
}


