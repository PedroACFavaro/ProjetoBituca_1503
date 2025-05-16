package br.com.fiap.projetobituca.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.prototipo_bituca.components.BotaoBonito
import br.com.fiap.prototipo_bituca.components.NomeAplicacao
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@SuppressLint("MissingPermission")
@Composable
fun MapaScreen(navController: NavController) {
    val context = LocalContext.current
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[android.Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        if (!granted) {
            Toast.makeText(context, "Permissão de localização necessária!", Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(Unit) {
        locationPermissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    // Coordenadas iniciais (endereço da fiap sede Paulista)
    val fiap = LatLng(-23.564074444601737, -46.65240796278048)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPositionState(
            position = CameraPosition(fiap, 16f, 0f, 0f)
        ).position
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
    ) {
        LogoTopRight()
        NomeAplicacao(
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopStart)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // Box que contém o mapa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFF272727))
            ) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(
                        isMyLocationEnabled = true // REMOVA a linha `mapStyleOptions`
                    ),
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = true,
                        myLocationButtonEnabled = true
                    )
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            BotaoBonito(
                label = "Voltar",
                onClick = { navController.navigate("menu") },
                color = Color(0xFFE09132),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

//@Composable
//fun RequestLocationPermission() {
//    val context = LocalContext.current
//    val permissionLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.RequestPermission()
//    ) { isGranted ->
//        if (!isGranted) {
//            Toast.makeText(context, "Permissão de localização necessária!", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
//    }
//}
