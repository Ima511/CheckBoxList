package com.example.checkboxlist

import android.os.Bundle
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkboxlist.ui.theme.CheckBoxListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        MyUI()
                }
            }
        }
    }
}

@Composable
fun MyUI(){
    // The checkbox: helps user to select an item
    // Can turn an option ON or OFF

    val toppings: List<String> = listOf("Cheese", "Tomato", "Spicy")
    val ctx = LocalContext.current

    Column(horizontalAlignment = Alignment.Start) {

        toppings.forEach {
            toppingName ->
            var checked by remember{
                mutableStateOf(true)
            }
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = checked,
                    onCheckedChange = {checkedStatus ->
                        checked = checkedStatus
                        Toast.makeText(ctx,
                            "You choose $toppingName $checked",
                            Toast.LENGTH_LONG
                        ).show()
                    })
                Text(text = toppingName)
            }
            
        }

    }

}

