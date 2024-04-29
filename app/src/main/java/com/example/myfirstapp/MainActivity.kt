package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
                    FoodListView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello, 我是 $name!",
            modifier = modifier
    )
}

@Composable
fun FoodListView(){
    var foodList = arrayOf("滷肉飯","義大利麵","焗烤","kfc","麥當當")

    var chosenFood by remember {
        mutableStateOf("")
    }

    Row {
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("今日餐點")
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = chosenFood)
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedButton(onClick = {

                chosenFood = foodList.random()
                Log.d("MyApp", "FoodListView: chosenfood = $chosenFood")

            }) {
                Text(text = "想吃請按我")
            }

        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            foodList.forEach { food ->
                Text(text = food)
            }
        }
    }
}


@Preview(
    showBackground = true,
    apiLevel = 33
)
@Composable
fun AppPreview() {
    MyFirstAppTheme {

//        Greeting("于庭")
        FoodListView()

    }
}