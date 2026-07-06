package com.example.prototipo_vissual.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prototipo_vissual.ui.attractor.AttractorScreen
import com.example.prototipo_vissual.ui.selector.SelectorScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Attractor.route
    ) {
        composable(Routes.Attractor.route) {
            AttractorScreen(
                onTriggered = {
                    navController.navigate(Routes.Selector.route)
                }
            )
        }
        composable(Routes.Selector.route) {
            SelectorScreen(
                onVerticalSelected = { vertical ->
                    // TODO: enviar al router de comando / módulo correspondiente
                },
                onBackToAttractor = {
                    navController.popBackStack(Routes.Attractor.route, inclusive = false)
                }
            )
        }
    }
}
