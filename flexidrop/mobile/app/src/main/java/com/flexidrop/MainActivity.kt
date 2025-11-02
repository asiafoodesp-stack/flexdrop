package com.flexidrop

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * MainActivity.kt
 * Autor: MiniMax Agent
 * Fecha: 2025-11-02
 * Descripción: Actividad principal de la aplicación móvil Flexidrop
 * 
 * Esta actividad gestiona:
 * - Navegación principal con fragments
 * - Bottom navigation bar
 * - Menu de opciones
 * - Inicialización de componentes
 */

class MainActivity : AppCompatActivity() {
    
    companion object {
        private const val V_TAG = "FlexidropMainActivity"
    }

    override fun onCreate(V_savedInstanceState: Bundle?) {
        super.onCreate(V_savedInstanceState)
        
        // Configurar el tema de la aplicación
        setTheme(R.style.Theme_Flexidrop)
        
        // Establecer el layout de la actividad
        setContentView(R.layout.activity_main)
        
        // Inicializar componentes de UI
        V_setupNavigation()
        V_setupActionBar()
        V_initializeComponents()
        
        // Log de inicialización
        android.util.Log.d(V_TAG, "Flexidrop MainActivity inicializada correctamente")
    }

    /**
     * Configura la navegación principal de la aplicación
     */
    private fun V_setupNavigation() {
        // Obtener el NavHostFragment
        val V_navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        
        val V_navController = V_navHostFragment.navController
        
        // Configurar Bottom Navigation
        val V_bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        V_bottomNavView?.setupWithNavController(V_navController)
        
        // Configurar listener para cambios de navegación
        V_bottomNavView?.setOnItemSelectedListener { V_menuItem ->
            when (V_menuItem.itemId) {
                R.id.navigation_home -> {
                    V_navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.navigation_search -> {
                    V_navController.navigate(R.id.searchFragment)
                    true
                }
                R.id.navigation_publish -> {
                    V_navController.navigate(R.id.publishFragment)
                    true
                }
                R.id.navigation_messages -> {
                    V_navController.navigate(R.id.messagesFragment)
                    true
                }
                R.id.navigation_profile -> {
                    V_navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }
        
        // Configurar destination change listener
        V_navController.addOnDestinationChangedListener { _, V_destination, _ ->
            when (V_destination.id) {
                R.id.homeFragment -> {
                    V_bottomNavView?.selectedItemId = R.id.navigation_home
                    supportActionBar?.title = "Flexidrop"
                }
                R.id.searchFragment -> {
                    V_bottomNavView?.selectedItemId = R.id.navigation_search
                    supportActionBar?.title = "Buscar"
                }
                R.id.publishFragment -> {
                    V_bottomNavView?.selectedItemId = R.id.navigation_publish
                    supportActionBar?.title = "Publicar"
                }
                R.id.messagesFragment -> {
                    V_bottomNavView?.selectedItemId = R.id.navigation_messages
                    supportActionBar?.title = "Mensajes"
                }
                R.id.profileFragment -> {
                    V_bottomNavView?.selectedItemId = R.id.navigation_profile
                    supportActionBar?.title = "Perfil"
                }
            }
        }
    }

    /**
     * Configura la Action Bar
     */
    private fun V_setupActionBar() {
        // Configurar Action Bar personalizada
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_flexidrop_logo)
            title = "Flexidrop"
            subtitle = "Movilidad Colaborativa"
        }
    }

    /**
     * Inicializa componentes adicionales de la aplicación
     */
    private fun V_initializeComponents() {
        // Aquí se pueden inicializar componentes globales
        // como servicios, repositorios, etc.
        
        V_checkAppUpdates()
        V_initializeServices()
    }

    /**
     * Verifica actualizaciones de la aplicación
     */
    private fun V_checkAppUpdates() {
        // Implementar lógica de verificación de actualizaciones
        android.util.Log.d(V_TAG, "Verificando actualizaciones de la app...")
    }

    /**
     * Inicializa servicios en segundo plano
     */
    private fun V_initializeServices() {
        // Inicializar servicios necesarios
        // - Servicio de notificaciones
        // - Servicio de ubicación
        // - Servicio de sincronización
        android.util.Log.d(V_TAG, "Inicializando servicios en segundo plano...")
    }

    /**
     * Crea el menú de opciones
     */
    override fun onCreateOptionsMenu(V_menu: Menu): Boolean {
        // Inflar el menú desde XML
        menuInflater.inflate(R.menu.main_menu, V_menu)
        return true
    }

    /**
     * Maneja clicks en items del menú
     */
    override fun onOptionsItemSelected(V_menuItem: MenuItem): Boolean {
        return when (V_menuItem.itemId) {
            R.id.action_search -> {
                // Abrir búsqueda avanzada
                V_openAdvancedSearch()
                true
            }
            R.id.action_notifications -> {
                // Abrir notificaciones
                V_openNotifications()
                true
            }
            R.id.action_settings -> {
                // Abrir configuración
                V_openSettings()
                true
            }
            R.id.action_help -> {
                // Abrir ayuda
                V_openHelp()
                true
            }
            android.R.id.home -> {
                // Manejar click del botón home
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(V_menuItem)
        }
    }

    /**
     * Abre la búsqueda avanzada
     */
    private fun V_openAdvancedSearch() {
        Toast.makeText(this, "Búsqueda avanzada", Toast.LENGTH_SHORT).show()
        // Implementar navegación a búsqueda avanzada
    }

    /**
     * Abre el panel de notificaciones
     */
    private fun V_openNotifications() {
        Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
        // Implementar navegación a notificaciones
    }

    /**
     * Abre la configuración
     */
    private fun V_openSettings() {
        Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
        // Implementar navegación a configuración
    }

    /**
     * Abre la ayuda
     */
    private fun V_openHelp() {
        Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show()
        // Implementar navegación a ayuda
    }

    /**
     * Maneja la pulsación del botón de back
     */
    override fun onBackPressed() {
        // Verificar si hay navegación personalizable
        val V_navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val V_navController = V_navHostFragment.navController
        
        if (!V_navController.popBackStack()) {
            // Si no se puede navegar hacia atrás, salir de la app
            super.onBackPressed()
        }
    }

    /**
     * Maneja la resolución de la actividad
     */
    override fun onResume() {
        super.onResume()
        
        // Actualizar datos al volver a la actividad
        V_refreshCurrentData()
    }

    /**
     * Refresca los datos de la pantalla actual
     */
    private fun V_refreshCurrentData() {
        android.util.Log.d(V_TAG, "Refrescando datos actuales...")
        // Implementar actualización de datos según el fragment actual
    }

    /**
     * Maneja cambios en la configuración del dispositivo
     */
    override fun onConfigurationChanged(V_newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(V_newConfig)
        
        // Manejar cambios de orientación, idioma, etc.
        android.util.Log.d(V_TAG, "Configuración cambiada: ${V_newConfig.orientation}")
    }

    /**
     * Maneja permisos concedidos
     */
    override fun onRequestPermissionsResult(
        V_requestCode: Int,
        V_permissions: Array<String>,
        V_grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(V_requestCode, V_permissions, V_grantResults)
        
        when (V_requestCode) {
            V_Constants.V_PERMISSION_LOCATION -> {
                if (V_grantResults.isNotEmpty() && V_grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    android.util.Log.d(V_TAG, "Permiso de ubicación concedido")
                    V_enableLocationFeatures()
                } else {
                    android.util.Log.w(V_TAG, "Permiso de ubicación denegado")
                    V_disableLocationFeatures()
                }
            }
            V_Constants.V_PERMISSION_CAMERA -> {
                if (V_grantResults.isNotEmpty() && V_grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    android.util.Log.d(V_TAG, "Permiso de cámara concedido")
                    V_enableCameraFeatures()
                } else {
                    android.util.Log.w(V_TAG, "Permiso de cámara denegado")
                    V_disableCameraFeatures()
                }
            }
            V_Constants.V_PERMISSION_STORAGE -> {
                if (V_grantResults.isNotEmpty() && V_grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    android.util.Log.d(V_TAG, "Permiso de almacenamiento concedido")
                    V_enableStorageFeatures()
                } else {
                    android.util.Log.w(V_TAG, "Permiso de almacenamiento denegado")
                    V_disableStorageFeatures()
                }
            }
        }
    }

    /**
     * Habilita características de ubicación
     */
    private fun V_enableLocationFeatures() {
        // Habilitar GPS, mapas, geolocalización
        Toast.makeText(this, "Características de ubicación habilitadas", Toast.LENGTH_SHORT).show()
    }

    /**
     * Deshabilita características de ubicación
     */
    private fun V_disableLocationFeatures() {
        // Deshabilitar GPS, mapas, geolocalización
        Toast.makeText(this, "Características de ubicación deshabilitadas", Toast.LENGTH_SHORT).show()
    }

    /**
     * Habilita características de cámara
     */
    private fun V_enableCameraFeatures() {
        // Habilitar cámara para fotos de perfil, documentos
        Toast.makeText(this, "Cámara habilitada", Toast.LENGTH_SHORT).show()
    }

    /**
     * Deshabilita características de cámara
     */
    private fun V_disableCameraFeatures() {
        // Deshabilitar cámara
        Toast.makeText(this, "Cámara deshabilitada", Toast.LENGTH_SHORT).show()
    }

    /**
     * Habilita características de almacenamiento
     */
    private fun V_enableStorageFeatures() {
        // Habilitar descarga/upload de archivos
        Toast.makeText(this, "Almacenamiento habilitado", Toast.LENGTH_SHORT).show()
    }

    /**
     * Deshabilita características de almacenamiento
     */
    private fun V_disableStorageFeatures() {
        // Deshabilitar descarga/upload de archivos
        Toast.makeText(this, "Almacenamiento deshabilitado", Toast.LENGTH_SHORT).show()
    }

    /**
     * Maneja errores no capturados
     */
    private fun V_handleUncaughtException(V_thread: Thread, V_ex: Throwable) {
        android.util.Log.e(V_TAG, "Error no capturado en thread ${V_thread.name}", V_ex)
        
        // Guardar log del error
        V_saveCrashLog(V_ex)
        
        // Mostrar mensaje de error al usuario
        runOnUiThread {
            Toast.makeText(
                this,
                "Ha ocurrido un error inesperado. Por favor, reinicia la aplicación.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    /**
     * Guarda el log del crash para análisis
     */
    private fun V_saveCrashLog(V_ex: Throwable) {
        try {
            val V_logDir = getExternalFilesDir(null)?.absolutePath
            val V_logFile = java.io.File(V_logDir, "crash_log_${System.currentTimeMillis()}.txt")
            
            val V_logWriter = java.io.PrintWriter(V_logFile)
            V_logWriter.println("Timestamp: ${java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date())}")
            V_logWriter.println("Android Version: ${android.os.Build.VERSION.RELEASE}")
            V_logWriter.println("Device: ${android.os.Build.MODEL}")
            V_logWriter.println("App Version: ${V_Constants.V_APP_VERSION}")
            V_logWriter.println()
            V_logWriter.println("Stack Trace:")
            V_ex.printStackTrace(V_logWriter)
            V_logWriter.close()
            
            android.util.Log.d(V_TAG, "Crash log guardado en: ${V_logFile.absolutePath}")
        } catch (V_e: Exception) {
            android.util.Log.e(V_TAG, "Error guardando crash log", V_e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.d(V_TAG, "MainActivity destruida")
    }
}