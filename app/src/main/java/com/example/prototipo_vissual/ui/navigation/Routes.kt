package com.example.prototipo_vissual.ui.navigation

sealed class Routes(val route: String) {
    object Attractor : Routes("attractor")
    object Selector : Routes("selector")
    // Los módulos se agregarán aquí más adelante, ej:
    // object ModulePizarra : Routes("module_pizarra")
}
