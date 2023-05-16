package com.example.logindemojetpack

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logindemojetpack.ui.theme.LoginDemoJetPackTheme

class RecycleritemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginDemoJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LoginDemoJetPackTheme {
        Greeting3("Android")
    }
}


fun addLogic(modelList: ModelList<MyModel>) {
    modelList.add(MyModel("Smith John", 10))
}

class MyModel(var name: String, var index: Int)

@Composable
fun RecycledList() { // Any name you want
    val modelList<Modellist> = modelListOf()
    var counter = 0

    addLogic(modelList)

    modelList.add(Modellist("John Doe", "fsfdsfs"))

    MaterialTheme {
        Column {
            Container(height = 70.dp) {
                Align(alignment = Alignment.Center) {
                    Button(onClick = {
                        modelList.add(MyModel("John Smith", counter++))
                        // Any other logic you want
                    }) {
                        Text("ADD ITEM")
                    }
                }
            }
            AdapterList(data = modelList) { item ->
                Center {
                    Text("Hello ${item.name} - Index: ${item.index}")
                }
            },
        }
    }
}