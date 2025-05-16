package br.com.fiap.projetobituca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.prototipo_bituca.components.NomeAplicacao

@Composable
fun SobreScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
    ) {
        LogoTopRight()
        NomeAplicacao(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp, start = 16.dp),
            color = Color.White
        )

        // Chamada do texto dentro do Box
        TextoAjustado(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun TextoAjustado(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Habilita rolagem vertical
    ) {
        Text(
            text = "• O aplicativo tem como objetivo monitorar e conscientizar a população sobre o impacto ambiental das bitucas de cigarro descartadas nas ruas.",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = "• Através do VCR (View of Cigarette Residues), os usuários poderão registrar a localização de bitucas encontradas.",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "• O aplicativo incentiva a participação ativa da população, promovendo uma cultura de responsabilidade coletiva na preservação do meio ambiente.",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "• As informações geradas pelo aplicativo permitem que organizações e prefeituras desenvolvam políticas mais eficazes para lidar com a poluição urbana.",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

//
//@Preview
//@Composable
//fun preview() {
//    SobreApp()
//}