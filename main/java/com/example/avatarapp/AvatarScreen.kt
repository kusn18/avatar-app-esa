package com.example.avatarapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AvatarScreen(
    onBack: () -> Unit = {}
) {
    var isBrowChecked by remember { mutableStateOf(true) }
    var isEyeChecked by remember { mutableStateOf(true) }
    var isNoseChecked by remember { mutableStateOf(true) }
    var isMouthChecked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Halaman Avatar", fontSize = 24.sp, style = MaterialTheme.typography.titleLarge)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {

            // KEPALA
            Image(
                painter = painterResource(id = R.drawable.img_head),
                contentDescription = "Head",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            // ALIS
            if (isBrowChecked) {
                Image(
                    painter = painterResource(id = R.drawable.img_brow),
                    contentDescription = "Brow",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                        .offset(y = (-30).dp)
                )
            }

            // MATA
            if (isEyeChecked) {
                Image(
                    painter = painterResource(id = R.drawable.img_eye),
                    contentDescription = "Eye",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(130.dp)
                        .height(80.dp)
                        .offset(y = (-5).dp)
                )
            }

            // HIDUNG
            if (isNoseChecked) {
                Image(
                    painter = painterResource(id = R.drawable.img_nose),
                    contentDescription = "Nose",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(40.dp)
                        .height(100.dp)
                        .offset(y = 25.dp)
                )
            }

            // MULUT
            if (isMouthChecked) {
                Image(
                    painter = painterResource(id = R.drawable.img_mouth),
                    contentDescription = "Mouth",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(50.dp)
                        .height(60.dp)
                        .offset(y = 60.dp)
                )
            }
        }

        // Widget Checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isBrowChecked,
                    onCheckedChange = { isBrowChecked = it }
                )
                Text("Brow")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isEyeChecked,
                    onCheckedChange = { isEyeChecked = it }
                )
                Text("Eye")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isNoseChecked,
                    onCheckedChange = { isNoseChecked = it }
                )
                Text("Nose")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isMouthChecked,
                    onCheckedChange = { isMouthChecked = it }
                )
                Text("Mouth")
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali ke Profil")
        }
    }
}