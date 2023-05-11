@file:OptIn(ExperimentalAnimationApi::class)

package com.example.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.common.navigation.NavigationEvent
import com.example.common.navigation.Routes
import com.example.common.navigation.navigate
import com.example.common.presentation.HomeViewModel
import com.example.home.presentation.HomeScreen
import com.example.home.state.HomeState
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(
        route = Routes.HomeGraph,
        startDestination = Routes.Home,
    ) {
        homeScreen(navController)
    }
}

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(
        route = Routes.Home
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        val state: HomeState by viewModel.viewState.collectAsStateWithLifecycle()
        HomeScreen(
            state = state,
            onEvent = { event ->
                when (event) {
                    is NavigationEvent -> navController.navigate(event)
                    else -> viewModel.setEvent(event)
                }
            },
        )
    }
}
