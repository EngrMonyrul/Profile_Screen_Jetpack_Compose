package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun ListViewScreenView() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Users") },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "")
                }
            },
        )
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            content = {
                items(GetTotalUsers()) { item ->
                    UserCard(
                        title = item.name,
                        subTitle = item.email,
                    )
                }
            },
        )
        /*Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            GetTotalUsers().map { item ->
                UserCard(
                    title = item.name,
                    subTitle = item.email,
                )
            }
        }*/
    }
}

@Composable
fun UserCard(title: String, subTitle: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Row {
            /*---------------> profile image <--------------*/
            Image(
                painter = painterResource(id = R.drawable.img_person),
                contentDescription = "person",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(height = 60.dp, width = 60.dp)
                    .padding(start = 10.dp)
                    .weight(.2f)
            )
            Spacer(Modifier.width(width = 10.dp))

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(.8f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                /*---------------> title <--------------*/
                Text(text = title, style = MaterialTheme.typography.headlineSmall)

                /*---------------> subtitle <--------------*/
                Text(
                    text = "monirul.se.cseuu@gmail.com",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            /*---------------> delete button <--------------*/
            Icon(
                Icons.Filled.Delete,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .align(alignment = Alignment.CenterVertically)
                    .background(color = Color.Red, CircleShape)
                    .padding(8.dp)
            )
        }
    }
}

/*---------------> data class <--------------*/
data class UserData(val name: String, val email: String)

/*---------------> total user <--------------*/
fun GetTotalUsers(): MutableList<UserData> {
    val userList = mutableListOf<UserData>()

    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))
    userList.add(UserData(name = "Monirul", email = "monirul.se.cseuu@gmail.com"))

    return userList
}