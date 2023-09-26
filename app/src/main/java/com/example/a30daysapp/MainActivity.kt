package com.example.a30daysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.data.Quotes
import com.example.a30daysapp.data.quotes
import com.example.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "30Days for Productivity"
                                         // You can customize the text color
                                    )
                                }
                            )
                        }
                    ) {
                        ProductivityApp(quotes = quotes)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductivityApp(
    quotes: List<Quotes>,
    modifier: Modifier = Modifier
){
        LazyColumn(contentPadding = PaddingValues(top = 56.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(quotes) {quote ->
                QuoteCard(
                    quote = quote,

                )

            }

        }
}

@Composable
fun QuoteCard(
    quote : Quotes
){
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = quote.day),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(id = quote.image) ,
                contentDescription =null ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = quote.quote),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top=8.dp)
                )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductivityAppPreview() {
    _30DaysAppTheme {
        ProductivityApp(quotes = quotes)
    }
}