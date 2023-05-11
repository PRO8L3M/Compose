package com.example.template

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.example.common.navigation.Routes
import com.example.home.navigation.homeGraph
import com.example.home.navigation.homeScreen
import com.example.template.ui.theme.TemplateTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.example.resources.R
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.collections.immutable.persistentListOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberAnimatedNavController()
            TemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        bottomBar = { BottomBar(navHostController = navController) }
                    ) { paddings ->
                        AnimatedNavHost(
                            navController = navController,
                            startDestination = Routes.HomeGraph,
                            route = Routes.MainGraph,
                            modifier = Modifier.padding(paddings),
                            enterTransition = { expandVertically() },
                            exitTransition = { shrinkVertically() }
                        ) {
                            homeGraph(navController)
                        }
                    }
                }
            }
        }
    }
}

sealed class BottomNavItem(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    val route: String,
) {
    object Home : BottomNavItem(R.string.home_tab, R.drawable.ic_home, Routes.HomeGraph)
}

@Composable
internal fun BottomBar(navHostController: NavHostController) {
    val currentBackStackEntry: NavBackStackEntry? by navHostController.currentBackStackEntryAsState()
    val currentRoute: String? = currentBackStackEntry?.destination?.parent?.route
    val items = persistentListOf(
        BottomNavItem.Home
    )
    val isBottomNavigationBarVisible: Boolean = items.any {
        currentRoute == it.route
    }
    AnimatedVisibility(visible = isBottomNavigationBarVisible) {
        NavigationBar {
            items.forEach {
                NavigationBarItem(
                    selected = it.route == currentRoute,
                    onClick = {
                       val navOptions = navOptions {
                           popUpTo(Routes.MainGraph) {
                               saveState = true
                           }
                           launchSingleTop = true
                           restoreState = true
                       }
                        navHostController.navigate(it.route, navOptions)
                    },
                    label = {
                        Text(text = stringResource(it.titleRes))
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = it.iconRes),
                            contentDescription = null,
                        )
                    },
                )
            }
        }
    }
}
