package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(Color(0xFF050B31)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = stringResource(R.string.android_logo),
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        TextLego(
            text = stringResource(R.string.mohamed_amer), color = Color.White, fontSize = 32.sp
        )
        TextLego(
            text = stringResource(R.string.android_developer),
            color = Color(0xFF3ddc84),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.padding(bottom = 400.dp))

        ContactRow(text = stringResource(R.string._20_100_9292_859), icon = Icons.Filled.Call)

        ContactRow(text = stringResource(R.string.androiddev), icon = Icons.Filled.Share)

        ContactRow(text = stringResource(R.string.mohamedamerjalal), icon = Icons.Filled.Email)
    }
}

@Composable
fun TextLego(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    Text(text = text, color = color, fontSize = fontSize, modifier = modifier)
}

@Composable
fun ContactRow(text: String, icon: ImageVector) {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF526E7B),
        thickness = 3.dp
    )
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.weight(1f)
        )
        TextLego(
            text = text, color = Color.White, modifier = Modifier
                .weight(3f)
                .blur(0.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}