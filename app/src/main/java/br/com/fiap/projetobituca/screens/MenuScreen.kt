package br.com.fiap.prototipo_bituca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetobituca.R
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.projetobituca.ui.theme.Poppins
import br.com.fiap.prototipo_bituca.components.BotaoBonito
import br.com.fiap.prototipo_bituca.components.NomeAplicacao

@Composable
fun MenuScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF161616))
        .padding(32.dp)
    ) {
        LogoTopRight()
        Column() {
            NomeAplicacao(color = Color.White)
            Spacer(modifier = Modifier.padding(top = 6.dp))
            Text(
                text = "MENU",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 6.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            BotaoBonito(label = "Contador de bitucas", onClick = { navController.navigate("contador") }, color =  Color(0xFFE09132))
            Spacer(modifier = Modifier.padding(10.dp))
            BotaoBonito(label = "Mapa de incidência", onClick = { navController.navigate("mapa")}, color =        Color(0xFFE09132))
        }
    }
}

//@Preview
//@Composable
//fun MenuScreenPreview() {
//    MenuScreen()
//}