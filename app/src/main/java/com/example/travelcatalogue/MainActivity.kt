package com.example.travelcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelcatalogue.ui.theme.TravelCatalogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelCatalogueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelScreen(modifier: Modifier = Modifier) {
    val imageList = listOf(
        R.drawable.taj_mahal_agra_india_square_1,
        R.drawable.download,
        R.drawable.indiagate,
        R.drawable.sanchijpg
    )

    var title by remember { mutableStateOf(R.string.taj) }
    var place by remember {
        mutableStateOf(R.string.up)
    }
    var currentImage by remember {
        mutableStateOf(imageList[0])
    }
    var imageResource by remember {
        mutableStateOf(currentImage)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name), fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) { innerPadding ->
        Spacer(modifier =modifier.size(16.dp))
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally){
            TravelImage(currentImage = currentImage)
            Spacer(modifier = modifier.size(16.dp))
            TravelTitle(title = title, place = place)
            Spacer(modifier = modifier.size(25.dp))

            Row(modifier = modifier.padding(horizontal = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Previous", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = colorResource(R.color.blue_300))
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Next", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = colorResource(R.color.gray_900))
                }
            }
        }
    }

}

@Composable
fun TravelImage(modifier: Modifier = Modifier, @DrawableRes currentImage: Int) {
    Image(
        painter = painterResource(currentImage),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun TravelTitle(@StringRes title: Int, @StringRes place: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(title),
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.blue_100),
            fontSize = 32.sp
        )
        Text(
            text = "--${stringResource(place)}--",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.gray_300)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelCatalogueTheme {
        TravelScreen()
    }
}