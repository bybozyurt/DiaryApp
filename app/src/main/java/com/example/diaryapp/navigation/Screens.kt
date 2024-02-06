package com.example.diaryapp.navigation

import com.example.diaryapp.util.Constants.ID_FIELD

sealed class Screens(val route : String) {
    data object Home : Screens("home")
    data object Authentication: Screens("auth")
    data object Enroll: Screens("enroll?$ID_FIELD={$ID_FIELD}") {
        fun passId(id: String) = "enroll?$ID_FIELD=$ID_FIELD"
    }
}