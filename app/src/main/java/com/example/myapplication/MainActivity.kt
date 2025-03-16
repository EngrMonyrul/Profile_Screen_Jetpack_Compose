package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*MyApplicationTheme { UserProfile() }*/
            MyApplicationTheme {
                ListViewScreenView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(
    pressedOnBack: () -> Unit = {}, clickOnMore: () -> Unit = {}
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
            title = { Text(text = "Profile", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = pressedOnBack) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft, contentDescription = "Back Button"
                    )
                }
            },
            actions = {
                IconButton(onClick = clickOnMore) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "More Icon")
                }
            })
    }) { innerPadding ->
        ProfileInformation(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
private fun ProfileInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileHeaderInformation()
        Spacer(modifier = Modifier.height(24.dp))
        ProfileDataSummary()
        Spacer(modifier = Modifier.height(24.dp))
        ProfileBioData()
        Spacer(modifier = Modifier.height(24.dp))
        SocialActions()
        Spacer(modifier = Modifier.height(30.dp))
        ViewProfileButton()
    }
}

@Composable
private fun ProfileHeaderInformation() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.size(height = 120.dp, width = 120.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_profile),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Box(modifier = Modifier.offset(x = (-7).dp, (-4).dp)) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "check circle",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(alignment = Alignment.BottomEnd)
                        .background(color = Color.White, CircleShape)
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            CircleShape
                        )
                )
            }
        }
        Text(
            text = "Monirul Islam", style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Jr Software Engineer",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun ProfileDataSummary() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        ProfileInformationState(label = "Projects", count = 30)
        ProfileInformationState(label = "Following", count = 120)
        ProfileInformationState(label = "Followers", count = 2000)
    }
}

@Composable
private fun ProfileBioData() {
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et est et velit ornare ultrices. Ut vitae diam volutpat risus eget.",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
private fun ProfileInformationState(label: String, count: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "$count+",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun SocialActions() {
    Row(
        modifier = Modifier.size(width = 250.dp, height = 50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.linkedin),
            contentDescription = "linkedin",
            modifier = Modifier.size(35.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "linkedin",
            modifier = Modifier.size(35.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.github),
            contentDescription = "linkedin",
            modifier = Modifier.size(35.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.envelope),
            contentDescription = "linkedin",
            modifier = Modifier.size(35.dp)
        )
    }
}

@Composable
private fun ViewProfileButton() {
    ElevatedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.size(width = 200.dp, height = 50.dp)
    ) {
        Text(text = "View Profile")
    }
}