package com.example.doctorathome

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.doctorathome.R
import com.example.doctorathome.screen.LoginPage
import com.example.doctorathome.screen.RegisterPage


enum class MainScreen(@StringRes val title: Int) {
    Login(title = R.string.app_name),
    Register(title = R.string.register)
}

@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = MainScreen.Login.name,
    ){
        composable(route = MainScreen.Login.name) {
            LoginPage(navController)
        }
        composable(route = MainScreen.Register.name) {
            RegisterPage(navController)
        }
    }
}