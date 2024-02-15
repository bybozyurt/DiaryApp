package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.example.diaryapp.common.NavigationArgs.ID_FIELD
import com.example.diaryapp.common.NavigationArgs.IS_INITIAL
import com.example.diaryapp.common.navigateToAuth
import com.example.diaryapp.common.navigateToHome
import com.example.diaryapp.presentation.screens.auth.AuthUiState
import com.example.diaryapp.presentation.screens.auth.AuthenticationViewModel
import com.example.diaryapp.presentation.screens.home.HomeScreen
import com.example.diaryapp.presentation.screens.home.HomeViewModel
import com.stevdzasan.messagebar.rememberMessageBarState

@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeRoute(
            navigateToAuth = {
                navController.popBackStack()
                navController.navigate(Screens.Authentication.route)
            }
        )
        authRoute(
            navigateToHome = { isInitial ->
                navController.popBackStack()
                navController.navigate(Screens.Home.passIsInitial(isInitial))
            }
        )
        enrollRoute()
    }
}

fun NavGraphBuilder.homeRoute(navigateToAuth: navigateToAuth) {
    composable(
        route = Screens.Home.route,
        arguments = listOf(
            navArgument(
                name = IS_INITIAL
            ) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->
        val vm: HomeViewModel = hiltViewModel()
        val uiState by vm.uiState.collectAsStateWithLifecycle()
        val isInitial = navBackStackEntry.arguments?.getBoolean(IS_INITIAL) ?: false

        LaunchedEffect(key1 = uiState.isLoggedOut) {
            if (uiState.isLoggedOut) {
                navigateToAuth()
            }
        }

        HomeScreen(
            isLoading = uiState.isLoading,
            isInitial = isInitial,
            onLogoutClick = { vm.logOut() }
        )
    }
}

fun NavGraphBuilder.authRoute(navigateToHome: navigateToHome) {
    composable(route = Screens.Authentication.route) {
        val messageBarState = rememberMessageBarState()
        val authVm: AuthenticationViewModel = hiltViewModel()
        val state by authVm.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = state.isLoggedIn) {
            if (state.isLoggedIn) {
                navigateToHome(true)
            }
        }

        AuthenticationScreen(
            isLoading = state.isLoading,
            messageBarState = messageBarState,
            onTokenIdReceived = { tokenId ->
                authVm.loginWithGoogle(tokenId)
            },
            onDialogDismissed = {
                authVm.setUiState(
                    AuthUiState(
                        isError = true
                    )
                )
            }
        )
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