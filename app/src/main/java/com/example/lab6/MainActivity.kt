package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Splash(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun Splash(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Fondo con imagen de lasaña
        Image(
            painter = painterResource(id = R.drawable.lasagna),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Agregar un overlay rojo semitransparente
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Red.copy(alpha = 0.3f))
        )
        Image(
            painter = painterResource(id = R.drawable.sombrerochef),
            contentDescription = "Chef Hat",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 65.dp) // Reduce el padding para subir un poco el sombrero
                .size(400.dp)  // Aumentar el tamaño del sombrero
        )
        // Texto más grande y centrado sobre la imagen
        Text(
            text = "Chef Recipes",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = FontFamily(Font(R.font.flats)),
                fontSize = 80.sp, // Tamaño de fuente más grande
                letterSpacing = 0.5.sp,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(6f, 6f),
                    blurRadius = 10f
                )
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab6Theme {
        MyApp()
    }
}

@Composable
fun Lab6Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = AppTypography,
        content = content
    )
}

val AppTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.flats)),
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        letterSpacing = 0.25.sp,
        shadow = Shadow(
            color = Color.Black,
            offset = Offset(4f, 4f),
            blurRadius = 8f
        )
    )
)
