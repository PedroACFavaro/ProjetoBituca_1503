package br.com.fiap.projetobituca

//import androidx.navigation.compose.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.projetobituca.screens.EntradaScreen
import br.com.fiap.projetobituca.screens.MapaScreen
import br.com.fiap.projetobituca.screens.SobreScreen
import br.com.fiap.projetobituca.ui.theme.ProjetoBitucaTheme
import br.com.fiap.prototipo_bituca.screens.ContadorScreen
import br.com.fiap.prototipo_bituca.screens.LoginScreen
import br.com.fiap.prototipo_bituca.screens.MenuScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoBitucaTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "entrada",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.Left,
                                tween(1000)
                            )
                            //+ fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ) {
                        composable(route = "entrada") {
                            EntradaScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(navController)
                        }
                        composable(route = "contador") {
                            ContadorScreen(navController)
                        }
                        composable(route = "mapa") {
                            MapaScreen(navController)
                        }
                        composable(route = "sobre") {
                            SobreScreen(navController)
                        }
                    }
                }
            }
        }
    }
}




