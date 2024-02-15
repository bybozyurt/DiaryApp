package com.example.diaryapp.navigation

import com.example.diaryapp.common.NavigationArgs.ID_FIELD
import com.example.diaryapp.common.NavigationArgs.IS_INITIAL

sealed class Screens(val route : String) {
    data object Home : Screens("home?${IS_INITIAL}={$IS_INITIAL}") {
        fun passIsInitial(isInitial: Boolean) = "home?$IS_INITIAL=$isInitial"
    }
    data object Authentication: Screens("auth")
    data object Enroll: Screens("enroll?$ID_FIELD={$ID_FIELD}") {
        fun passId(id: String) = "enroll?$ID_FIELD=$ID_FIELD"
    }
}