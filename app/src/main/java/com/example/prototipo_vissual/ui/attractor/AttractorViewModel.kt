package com.example.prototipo_vissual.ui.attractor

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AttractorViewModel : ViewModel() {

    private val _isListening = MutableStateFlow(false)
    val isListening: StateFlow<Boolean> = _isListening

    fun startListening() {
        _isListening.value = true
        // TODO: conectar VoskRecognizer aquí cuando esté listo
    }

    fun stopListening() {
        _isListening.value = false
    }

    fun onTouchDetected(onTriggered: () -> Unit) {
        stopListening()
        onTriggered()
    }
}
