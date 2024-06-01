package com.example.my_proj

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.example.my_proj.ui.theme.My_ProjTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        updateContent()

    }
    private fun updateContent(){
        setContent {
            My_ProjTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting( modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Image(painterResource(id = R.drawable.fongame),null,
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop)

    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()){
        val(clickCount, setClickCount) = remember { mutableIntStateOf(0) }

        if(clickCount >= 100) {
            Box(contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "You clicked more\n\n " +
                            "100 times, and\n\n " +
                            "according to the\n\n " +
                            "task you won,\n\n " +
                            "hahahahaha",
                    color = Color.Cyan,
                    fontSize = TextUnit(10f, TextUnitType.Em),
                    fontWeight = FontWeight.ExtraBold,
                    textDecoration = TextDecoration.None
                )
            }
            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()) {
                TextButton(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(50)
                        ),
                    onClick = { setClickCount(clickCount - clickCount) }
                ) {
                    Text(text = "RESTART")
                }
            }
        }else{
        Box(contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxWidth()){
            Text(
                text = "You tap \n\n\n $clickCount",
                color = Color.Cyan,
                fontSize = TextUnit(12f, TextUnitType.Em),
                fontWeight = FontWeight.ExtraBold,
                textDecoration = TextDecoration.None
            )
        }
        Box(contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()){
            TextButton(
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(
                        Color.DarkGray,
                        shape = RoundedCornerShape(50)
                    ),
                onClick = { setClickCount(clickCount + 1) }
            ) {
                Text(text = "TAP")
            }
        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_ProjTheme {
        Greeting()
    }
}