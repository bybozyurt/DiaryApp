package com.example.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapp.R
import com.example.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.example.diaryapp.common.Constants.ID_FIELD
import com.example.diaryapp.common.UiText
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
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screens.Home.route)
            }
        )
        enrollRoute()
    }
}

fun NavGraphBuilder.homeRoute(navigateToAuth: navigateToAuth) {
    composable(route = Screens.Home.route) {
        val vm: HomeViewModel = hiltViewModel()
        val messageBarState = rememberMessageBarState()
        val uiState by vm.uiState.collectAsStateWithLifecycle()

        val context = LocalContext.current
        val errorMessage = uiState.errorMessage.asString(context)
        val successMessage = uiState.successMessage.asString(context)

        LaunchedEffect(key1 = errorMessage, key2 = successMessage) {
            if (errorMessage.isNotEmpty()) {
                messageBarState.addError(Exception(errorMessage))
                vm.consumeErrorMessage()
            }
            if (successMessage.isNotEmpty()) {
                messageBarState.addSuccess(successMessage)
                navigateToAuth()
                vm.consumeSuccessMessage()
            }
        }

        HomeScreen(
            isLoading = uiState.isLoading,
            onLogoutClick = { vm.logOut() },
            messageBarState =messageBarState
        )
    }
}

fun NavGraphBuilder.authRoute(navigateToHome: navigateToHome) {
    composable(route = Screens.Authentication.route) {
        val messageBarState = rememberMessageBarState()
        val authVm: AuthenticationViewModel = hiltViewModel()
        val state by authVm.uiState.collectAsStateWithLifecycle()
        val message = state.uiText.asString(LocalContext.current)

        LaunchedEffect(key1 = state.uiText) {
            if (message.isNotEmpty()) {
                if (state.isError) {
                    messageBarState.addError(Exception(message))
                } else {
                    messageBarState.addSuccess(message)
                }
                authVm.consumeMessage()
            }
        }

        LaunchedEffect(key1 = state.isLoggedIn) {
            if (state.isLoggedIn) {
                navigateToHome()
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
                        isError = true,
                        uiText = UiText.StringResource(R.string.dialog_dismissed)
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