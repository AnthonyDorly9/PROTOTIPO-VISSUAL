# PROTOTIPO-VISSUAL (BTOUCH Showcase)

Aplicación Android nativa diseñada para instalarse en pantallas interactivas **BTOUCH**, con el objetivo de convertir las demostraciones comerciales en una experiencia guiada, atractiva y controlable — tanto por **toque** como por **comandos de voz offline**.

## 🎯 Propósito

Cuando un vendedor demuestra un panel interactivo frente a un cliente (universidades, empresas, oficinas en Arequipa), muchas veces la demo se limita a tocar la pantalla como si fuera una tablet grande, sin transmitir el verdadero potencial del hardware. Esta app resuelve eso con:

- Un **modo atractor** en bucle que capta la atención cuando el panel está inactivo.
- Un **selector de vertical** (Educación, Corporativo, Retail) que adapta la demo al público.
- **Módulos interactivos** (pizarra multitáctil, gestos, split-screen) que muestran las capacidades reales del panel.
- **Comandos de voz offline** (sin depender de Google Assistant ni internet) para navegar la demo con las manos libres.
- Un **panel de configuración previa** para personalizar la demo según el cliente que se va a visitar.

## 📱 Compatibilidad

- **SDK mínimo:** API 33 (Android 13)
- **Sin dependencia de Google Play Services** — los paneles BTOUCH corren Android AOSP/certificación empresarial, sin Google app instalada.
- Diseñada para **pantallas grandes**, entrada táctil como principal, con soporte adicional de navegación por D-pad/control remoto.

## 🏗️ Arquitectura

Patrón **MVVM** con separación estricta de capas: `data → domain → ui`, sin dependencias inversas.

```
app/src/main/java/com/example/prototipo_vissual/
├── data/
│   ├── local/          → Room: entidades, DAOs, Database
│   └── repository/     → Repositorios que abstraen el origen de los datos
├── domain/
│   └── model/          → Data classes puras (DemoProfile, Module, Vertical)
├── ui/
│   ├── theme/           → Material 3: colores, tipografía, tema
│   ├── attractor/        → Pantalla + ViewModel del modo atractor
│   ├── selector/         → Pantalla + ViewModel del selector de vertical
│   ├── modules/          → Pantallas de cada módulo interactivo
│   └── navigation/       → NavGraph y definición de rutas
├── voice/
│   ├── VoskRecognizer.kt  → Wrapper del motor de reconocimiento offline
│   ├── CommandMatcher.kt  → Traduce texto reconocido → evento de navegación
│   └── VoiceCommand.kt    → Comandos de voz soportados (lista cerrada)
└── di/                   → (Opcional) Módulos de inyección de dependencias
```

## 🎙️ Reconocimiento de voz — por qué offline

Los paneles BTOUCH no incluyen Google Play Services, por lo que **App Actions / Asistente de Google no son viables**. En su lugar, la app usa **Vosk** (motor de reconocimiento de voz 100% offline) con una **gramática de comandos cerrada** (ej. *"abre pizarra"*, *"muéstrame retail"*), priorizando confiabilidad en demos en vivo por sobre dictado libre en lenguaje natural.

## 🔄 Flujo general

1. **Modo atractor** — animación en bucle, escucha continua de Vosk + espera de toque.
2. **Disparador** — toque en pantalla *o* comando de voz reconocido.
3. **Router de comando** — decide si va al selector de vertical o directo a un módulo.
4. **Módulo interactivo** — la demo en sí (pizarra, gestos, etc.).
5. **Retorno automático** al modo atractor tras un período de inactividad.

## 🛠️ Stack técnico

| Categoría | Tecnología |
|---|---|
| UI | Jetpack Compose + Material 3 |
| Arquitectura | MVVM |
| Navegación | Navigation Compose |
| Persistencia | Room |
| Voz | Vosk (offline, modelo `vosk-model-small-es-0.42`) |
| Build | Kotlin DSL (`build.gradle.kts`) |

## 🚧 Estado actual

Proyecto en fase inicial — estructura de carpetas y arquitectura base definidas. En construcción: `NavGraph`, pantallas base (atractor/selector) y wrapper de Vosk.


