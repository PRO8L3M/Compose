package com.example.common.navigation

import androidx.navigation.NavOptions
import com.example.common.base.Event

interface NavigationEvent : Event {
    val route: String
    val navOptions: NavOptions?
}
