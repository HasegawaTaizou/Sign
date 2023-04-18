package br.senai.sp.jandira.tripapp.gui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.model.User
import br.senai.sp.jandira.tripapp.repository.UserRepository
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import kotlin.contracts.contract

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TripAppTheme {

                Column() {
                    SignUpScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreen() {

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        photoUri = uri
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUri)
            .build()
    )

    var userNameState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 18.dp, end = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Column(
                modifier = Modifier.padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(id = R.string.sign_up),
                    color = colorResource(id = R.color.primary_color),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    stringResource(id = R.string.create_account),
                    color = colorResource(id = R.color.secondary_color),
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    //     contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier.size(100.dp),

                        shape = CircleShape,
                        backgroundColor = Color(232, 232, 232, 255)
                    ) {
                        Image(
                            painter =
                            if (photoUri == null) painterResource(id = R.drawable.user)
                            else painter,
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                            )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.photo_24),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clickable {
                                launcher.launch("image/*")
                                var message = "nada"
                                Log.i("ds2m", "URI: ${photoUri?.path ?: message}")
                            }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier
                        .height(280.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    OutlinedTextField(
                        modifier = Modifier.width(320.dp),
                        value = userNameState,
                        onValueChange = { userNameState = it },
                        label = {
                            Text(
                                stringResource(id = R.string.username)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24),
                                contentDescription = stringResource(id = R.string.user_description),
                                tint = colorResource(id = R.color.primary_color)
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = colorResource(id = R.color.primary_color)
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier.width(320.dp),
                        value = phoneState,
                        onValueChange = { phoneState = it },
                        label = {
                            Text(
                                stringResource(id = R.string.phone)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone_24),
                                contentDescription = stringResource(id = R.string.phone_description),
                                tint = colorResource(id = R.color.primary_color)
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = colorResource(id = R.color.primary_color)
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier.width(320.dp),
                        value = emailState,
                        onValueChange = { emailState = it },
                        label = {
                            Text(
                                stringResource(id = R.string.email)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = stringResource(id = R.string.email_description),
                                tint = colorResource(id = R.color.primary_color)
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = colorResource(id = R.color.primary_color)
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier.width(320.dp),
                        value = passwordState,
                        onValueChange = { passwordState = it },
                        label = {
                            Text(
                                stringResource(id = R.string.password)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = stringResource(id = R.string.password),
                                tint = colorResource(id = R.color.primary_color)
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primary_color),
                            unfocusedBorderColor = colorResource(id = R.color.primary_color)
                        )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(checked = over18State, onCheckedChange = { over18State = it })
                        Text(stringResource(id = R.string.over_18), fontSize = 14.sp)
                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = {
                                saveUser(
                                    userNameState,
                                    phoneState,
                                    emailState,
                                    passwordState,
                                    over18State,
                                    photoUri!!.path ?: "",
                                    context
                                )
                            },
                            modifier = Modifier
                                .width(320.dp)
                                .height(48.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary_color))

                        ) {
                            Text(
                                stringResource(id = R.string.create_account).uppercase(),
                                color = Color.White,
                                fontSize = 16.sp,
                            )
                        }

                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 28.dp, end = 28.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.already_have_account
                        ),
                        color = colorResource(id = R.color.secondary_color),
                        fontSize = 12.sp,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.clickable {
                            val openOther = Intent(context, MainActivity::class.java)
                            context.startActivity(openOther)
                        },
                        text = stringResource(
                            id = R.string.sign_in
                        ),
                        color = colorResource(id = R.color.primary_color),
                        fontSize = 12.sp,

                        )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }
    }
}

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    profilePhotoUri: String,
    context: Context
) {
    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18,
        profilePhoto = profilePhotoUri
    )

    val userRepository = UserRepository(context)

    //verificar se o usuario ja existe
    val user = userRepository.findUserByEmail(email)

    Log.i("DS2M", "${user.toString()}")

    if (user == null) {
        //salvar usuario
        val id = userRepository.save(newUser)

        Toast.makeText(context, "Created user #$id", Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(context, "User already exists", Toast.LENGTH_LONG).show()
    }

}
