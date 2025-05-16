package br.com.fiap.projetobituca.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import br.com.fiap.projetobituca.R
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.prototipo_bituca.components.BotaoBonito
import br.com.fiap.prototipo_bituca.components.NomeAplicacao

@Composable
fun EntradaScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        LogoTopRight()
        Image(
            painter = painterResource(id = R.drawable.cigarro),
            contentDescription = "cigarro",
            contentScale = ContentScale.Crop, // Preenche toda a tela sem distorcer
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween, // Empurra os elementos para os extremos
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NomeAplicacao(color = Color.Black)
            // Nome no topo
            Spacer(modifier = Modifier.padding(100.dp))
            Text(
                text = "A mudança começa com um clique. Registre, impacte, inspire!",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.weight(1f)) // Empurra o botão para baixo
            BotaoBonito(
                label = "Sobre",
                onClick = { navController.navigate("sobre") },
                color =  Color(0xFFE09132),
                modifier = Modifier.fillMaxWidth()
            )

            BotaoBonito(
                label = "Começar",
                onClick = {navController.navigate("login")},
                color =  Color(0xFFE09132),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



//@Preview
//@Composable
//fun abelha() {
//    EntradaScreen()
//}
