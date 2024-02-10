package com.example.diaryapp.presentation.google

import androidx.credentials.exceptions.GetCredentialException
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.example.diaryapp.util.Constants
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.launch

@Composable
fun SignInWithGoogle(
    state: GoogleSignInState,
    clientId: String = Constants.googleClientId,
    rememberAccount: Boolean = true,
    nonce: String? = null,
    onTokenIdReceived: (String) -> Unit,
    onDialogDismissed: (String) -> Unit,
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val credentialManager = remember { CredentialManager.create(context) }

    val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setServerClientId(clientId)
        .setNonce(nonce)
        .setFilterByAuthorizedAccounts(rememberAccount)
        .build()

    val request: GetCredentialRequest = GetCredentialRequest.Builder()
        .setCredentialOptions(listOf(googleIdOption))
        .build()

    LaunchedEffect(key1 = state.opened) {
        if (state.opened) {
            scope.launch {
                try {
                    val response = credentialManager.getCredential(
                        request = request,
                        context = context,
                    )
                    handleSignIn(
                        credentialResponse = response,
                        onTokenIdReceived = {
                            onTokenIdReceived(it)
                            state.close()
                        },
                        onDialogDismissed = {
                            onDialogDismissed(it)
                            state.close()
                        }
                    )
                } catch (e: GetCredentialException) {
                    try {
                        val errorMessage = if (e.message != null) {
                            if (e.message!!.contains("activity is cancelled by the user.")) {
                                "Dialog Closed."
                            } else if (e.message!!.contains("Caller has been temporarily blocked")) {
                                "Sign in has been Temporarily Blocked due to too many Closed Prompts."
                            } else {
                                e.message.toString()
                            }
                        } else "Unknown Error."
                        onDialogDismissed(errorMessage)
                        state.close()
                    } catch (e: Exception) {
                        onDialogDismissed("${e.message}")
                        state.close()
                    }
                } catch (e: Exception) {
                    onDialogDismissed("${e.message}")
                    state.close()
                }
            }
        }
    }
}

private fun handleSignIn(
    credentialResponse: GetCredentialResponse,
    onTokenIdReceived: (String) -> Unit,
    onDialogDismissed: (String) -> Unit,
) {
    when (val credential = credentialResponse.credential) {
        is CustomCredential -> {
            if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                try {
                    val googleIdTokenCredential = GoogleIdTokenCredential
                        .createFrom(credential.data)
                    onTokenIdReceived(googleIdTokenCredential.idToken)
                } catch (e: GoogleIdTokenParsingException) {
                    onDialogDismissed("Invalid Google tokenId response: ${e.message}")
                }
            } else {
                onDialogDismissed("Unexpected Type of Credential.")
            }
        }

        else -> {
            onDialogDismissed("Unexpected Type of Credential.")
        }
    }
}