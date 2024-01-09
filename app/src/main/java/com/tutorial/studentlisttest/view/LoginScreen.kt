package com.tutorial.studentlisttest.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorial.studentlisttest.R
import com.tutorial.studentlisttest.model.isAdmin

@Composable
fun LoginScreen(navigateToStudents: () -> Unit){

//    show alfagift logo
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_alfagift),
            alignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .padding(top = 50.dp),
            contentDescription = "logo alfagift")
    }

//    show card
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            border = BorderStroke(2.dp, Color(0xFFdddddd)),
            modifier = Modifier.size(width = 320.dp, height = 370.dp),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "Login",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(15.dp))

//                TextField1 -- USERNAME FIELD
                Text(
                    text = "Username",
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                BasicTextField(
                    value = username,
                    onValueChange = { newText ->
                        username = newText
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFdddddd),
                                    shape = RoundedCornerShape(size = 5.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 10.dp), // inner padding
                        ) {
                            if (username.isEmpty()) {
                                Text(
                                    text = "enter username",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.LightGray
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

//                TextField2 -- PASSWORD FIELD
                Text(
                    text = "Password",
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                BasicTextField(
                    value = password,
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { newText ->
                        password = newText
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFdddddd),
                                    shape = RoundedCornerShape(size = 5.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 10.dp), // inner padding
                        ) {
                            if (username.isEmpty()) {
                                Text(
                                    text = "enter password",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.LightGray
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF185cac)
                    ),
                    shape = RoundedCornerShape(size = 5.dp),
                    onClick = {
                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            if (isAdmin(username, password)) {
                                navigateToStudents()
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}