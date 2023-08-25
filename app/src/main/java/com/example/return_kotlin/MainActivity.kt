package com.example.return_kotlin

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.return_kotlin.ui.theme.Return_KotlinTheme
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Return_KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var stateBottomSheet  = rememberModalBottomSheetState()
                    var isExpanded = rememberSaveable {
                        mutableStateOf(false)
                    }
                  Box(modifier = Modifier.fillMaxSize()){
                      Button(onClick = {
                          isExpanded.value =true
                      }) {
                          Text(text = "Click")
                      }
                  }
                    if(isExpanded.value) {
                        ModalBottomSheet(
                            sheetState = stateBottomSheet,
                            onDismissRequest = {
                                isExpanded.value = false

                            }, dragHandle = {

                            }
                        ) {
                            Surface(
                                modifier = Modifier
                                    .height(500.dp)
                                    .fillMaxWidth(), color = androidx.compose.ui.graphics.Color.Blue
                            ) {

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Return_KotlinTheme {
        Greeting("Android")
    }
}