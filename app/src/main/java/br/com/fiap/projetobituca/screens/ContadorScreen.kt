package br.com.fiap.prototipo_bituca.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.prototipo_bituca.components.BotaoBonito
import br.com.fiap.prototipo_bituca.components.NomeAplicacao

@Composable
fun ContadorScreen(navController: NavController) {
    var contador = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(12.dp) // Mantém o padding para NomeAplicacao
    ) {
        LogoTopRight()
        // NomeAplicacao no canto superior esquerdo
        NomeAplicacao(
            color = Color.White,
            modifier = Modifier.align(Alignment.TopStart)
        )

        // Conteúdo centralizado
        Column(
            modifier = Modifier
                .fillMaxSize(), // Ocupa toda a tela
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Contador de bitucas",
                color = Color.White,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Pressione os botões para adicionar ou remover as bitucas encontradas",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            BotaoBonito(label = "Local Atual", onClick = { /*TODO*/ }, color =  Color(0xFFE09132))
            BotaoBonito(label = "Relatar local", onClick = { /*TODO*/ }, color =  Color(0xFFE09132))

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = contador.value.toString(),
                color = Color.White,
                fontSize = 60.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Botões de contagem
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { contador.value-- },
                    modifier = Modifier.size(90.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE09132))
                ) {
                    Text(text = "-", fontSize = 50.sp)
                }

                Button(
                    onClick = { contador.value++ },
                    modifier = Modifier.size(90.dp),
                    colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFE09132))
                ) {
                    Text(text = "+", fontSize = 50.sp)
                }
            }
            Spacer(modifier = Modifier.padding(35.dp))
            BotaoBonito(label = "Voltar", onClick = { navController.navigate("menu") }, color =  Color(0xFFE09132))
        }
    }
}
