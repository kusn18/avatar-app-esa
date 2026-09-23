package com.example.avatarapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    user: UserData,
    onLogout: () -> Unit,
    onViewAvatar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(32.dp))
            Text("Halaman Profil User", fontSize = 24.sp, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "👤",
                        fontSize = 48.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("First Name: ${user.firstName}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Last Name: ${user.lastName}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Username: ${user.username}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Email: ${user.email}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Telepon: ${user.phone}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Alamat: ${user.address}", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Jenis Kelamin: ${user.gender}", fontSize = 16.sp)
                }
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = onViewAvatar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Lihat Avatar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = onLogout,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}