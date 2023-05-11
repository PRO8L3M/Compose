package com.example.common.navigation

import androidx.navigation.NavController

fun NavController.navigate(event: NavigationEvent) {
    navigate(
        route = event.route,
        navOptions = event.navOptions,
    )
}
