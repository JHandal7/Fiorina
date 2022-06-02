package com.example.fiorina

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fiorina.ui.theme.FiorinaTheme
import kotlin.reflect.KProperty


//new branch2
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
               // Greeting("Android")
                MyScreenContent()
            }
        }
    }
@Composable
fun MyApp(content: @Composable ()->Unit){
    FiorinaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()

        }
    }
}
    @Composable
    fun MyScreenContent(names:List<String> = List(100) {"Hello Android $it"}){
        var counterState by remember { mutableStateOf(1) }
        Column (modifier = Modifier.fillMaxHeight()){
  NamesList(names=names ,modifier = Modifier.weight(1f))

            Counter(count = counterState,
                update = { newValue -> counterState = newValue })

            if (counterState > 6) {
                Text("I love to count")
            }

        }

    }

    @Composable
    fun Counter(count:Int,update:(Int)->Unit){

        Button(onClick={ update(count+1 ) })

    {  Text("I have been clicked $count times") }

    }

@Composable
fun Greeting(name: String) {
    var isSelected by remember{ mutableStateOf(false)}
    val targetColor by animateColorAsState(if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
    animationSpec = tween(7000)
    )
    androidx.compose.material.Surface() {
Surface(color=targetColor) {
    Text("Hello $name!", modifier = Modifier
        .clickable { isSelected = !isSelected }
        .padding(16.dp))
}

}

}
    @Composable
    fun NamesList(names:List<String> = listOf("Android","There"),modifier: Modifier) {
        LazyColumn(modifier = modifier){
        items(items =names){
            Greeting(it)
            Divider()
        }
          }
             }

            @Composable
            @Preview(showBackground = true)
            fun DefaultPreview() {
                MyApp {
                    // Greeting("Android")
                    MyScreenContent()

                }
            }

        }//MainActivity

