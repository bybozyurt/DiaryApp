package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.presentation.screens.AuthenticationScreen
import com.example.diaryapp.util.Constants.ID_FIELD

@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeRoute()
        authRoute()
        enrollRoute()
    }
}

fun NavGraphBuilder.homeRoute() {
    composable(route = Screens.Home.route) {}
}

fun NavGraphBuilder.authRoute() {
    composable(route = Screens.Authentication.route) {
        AuthenticationScreen()
    }
}

fun NavGraphBuilder.enrollRoute() {
    composable(
        route = Screens.Enroll.route,
        arguments = listOf(
            navArgument(
                name = ID_FIELD,
                builder = {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        )
    ) {}
}