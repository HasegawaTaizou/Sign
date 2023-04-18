package br.senai.sp.jandira.tripapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //intent.extras
        Log.i("ds2m", "ID: ")

        setContent {
            TripAppTheme {
                Column() {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Card(
                modifier = Modifier.height(197.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(size = 12.dp),
                backgroundColor = Color.Magenta
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, end = 12.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.susanna_profile),
                        contentDescription = stringResource(id = R.string.susanna_description),
                        modifier = Modifier
                            .size(62.dp)
                            .clip(shape = CircleShape)
                            .border(2.dp, Color.White, shape = CircleShape)
                    )
                    Text(
                        text = stringResource(id = R.string.susanna_hoffs),
                        modifier = Modifier.padding(top = 6.dp),
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.location_24),
                            contentDescription = stringResource(id = R.string.location_description),
                            tint = Color.White
                        )
                        Text(stringResource(id = R.string.youre_in_paris), color = Color.White)
                    }
                    Text(
                        text = stringResource(id = R.string.my_trips),
                        modifier = Modifier.padding(start = 26.dp, bottom = 10.dp),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.categories),
                )
                LazyRow() {}
                OutlinedTextField(
                    modifier = Modifier.width(320.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            stringResource(R.string.search_your_destiny)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_24),
                            contentDescription = stringResource(R.string.search_your_destiny_description),
//
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(20.dp)
                )
                Text(text = "Past Trips")
                LazyColumn() {}
            }
        }

    }
}

