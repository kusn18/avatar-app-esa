package com.example.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avatarapp.ui.theme.AvatarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var registeredUser by remember { mutableStateOf(UserData()) }

    NavHost(
        navController = navController,
        startDestination = Screen.Registration.route
    ) {
        composable(Screen.Registration.route) {
            RegistrationScreen(
                onSave = { user ->
                    registeredUser = user
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Profile.route)
                },
                onForgotPassword = { /* TODO: Implementasi Lupa Password */ }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                user = registeredUser,
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onViewAvatar = {
                    navController.navigate(Screen.Avatar.route)
                }
            )
        }

        composable(Screen.Avatar.route) {
            AvatarScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun SinglePageRunner() {
    var selectedScreen by remember { mutableStateOf("Registration") }
    var mockUser by remember {
        mutableStateOf(
            UserData(
                firstName = "Budi",
                lastName = "Santoso",
                username = "budis",
                email = "budi@example.com",
                phone = "08123456789",
                address = "Malang, Jawa Timur",
                gender = "Laki-laki"
            )
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = when (selectedScreen) {
                "Registration" -> 0
                "Login" -> 1
                "Profile" -> 2
                "Avatar" -> 3
                else -> 0
            }
        ) {
            Tab(
                selected = selectedScreen == "Registration",
                onClick = { selectedScreen = "Registration" },
                text = { Text("Registration") }
            )
            Tab(
                selected = selectedScreen == "Login",
                onClick = { selectedScreen = "Login" },
                text = { Text("Login") }
            )
            Tab(
                selected = selectedScreen == "Profile",
                onClick = { selectedScreen = "Profile" },
                text = { Text("Profile") }
            )
            Tab(
                selected = selectedScreen == "Avatar",
                onClick = { selectedScreen = "Avatar" },
                text = { Text("Avatar") }
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedScreen) {
                "Registration" -> RegistrationScreen(
                    onSave = { mockUser = it },
                    onNavigateToLogin = {}
                )
                "Login" -> LoginScreen(onLoginSuccess = {})
                "Profile" -> ProfileScreen(user = mockUser, onLogout = {}, onViewAvatar = {})
                "Avatar" -> AvatarScreen()
            }
        }
    }
}