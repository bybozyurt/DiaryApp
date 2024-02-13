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
import com.example.diaryapp.presentation.google.rememberGoogleSignInState
import com.example.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.example.diaryapp.common.Constants.ID_FIELD
import com.example.diaryapp.presentation.screens.auth.AuthenticationViewModel
import com.stevdzasan.messagebar.rememberMessageBarState

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
        val googleSignInState = rememberGoogleSignInState()
        val messageBarState = rememberMessageBarState()
        val authVm: AuthenticationViewModel = hiltViewModel()
        val state by authVm.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = state.message) {
            if (state.isError && state.message.isNotEmpty()) {
                messageBarState.addError(Exception(state.message))
                authVm.consumeMessage()
            }

            if (!state.isError && state.message.isNotEmpty()) {
                messageBarState.addSuccess(state.message)
                authVm.consumeMessage()
            }
        }

        AuthenticationScreen(
            state = googleSignInState,
            isLoading = state.isLoading,
            messageBarState = messageBarState,
            onTokenIdReceived = { tokenId ->
                authVm.loginWithGoogle(tokenId)
            },
            onDialogDismissed = {
                authVm.setMessage(isError = true, message = "Dialog Dismissed")
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