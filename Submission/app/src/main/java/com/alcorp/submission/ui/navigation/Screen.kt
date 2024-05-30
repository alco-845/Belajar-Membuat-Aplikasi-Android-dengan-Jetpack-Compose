package com.alcorp.submission.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailShip : Screen("home/{id}") {
        fun createRoute(id: Int) = "home/$id"
    }
}