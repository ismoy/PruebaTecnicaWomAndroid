package com.github.comismoy.pruebatecnicawomandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation.NavigationManager
import com.github.comismoy.pruebatecnicawomandroid.ui.theme.PruebaTecnicaWomAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PruebaTecnicaWomAndroidTheme {
                NavigationManager()
            }
        }
    }
}

