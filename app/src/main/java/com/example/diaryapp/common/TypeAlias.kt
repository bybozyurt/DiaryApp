package com.example.diaryapp.common

typealias onClick = () -> Unit
typealias onTokenIdReceived = (String) -> Unit
typealias onDialogDismissed = (String) -> Unit

//Navigation
typealias navigateToHome = (Boolean) -> Unit
typealias navigateToAuth = () -> Unit

//Menu
typealias onDismissedRequest = () -> Unit