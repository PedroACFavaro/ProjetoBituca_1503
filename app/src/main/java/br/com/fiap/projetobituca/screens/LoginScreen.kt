package br.com.fiap.prototipo_bituca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetobituca.components.LogoTopRight
import br.com.fiap.prototipo_bituca.components.BotaoBonito
import br.com.fiap.prototipo_bituca.components.CaixaDeEntrada
import br.com.fiap.prototipo_bituca.components.NomeAplicacao

@Composable
fun LoginScreen(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var erroUsuario by remember { mutableStateOf(false) }
    var erroSenha by remember { mutableStateOf(false) }

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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Login: 'aluno', senha: '1234'", color = Color.White)
            Text(text = "Obs: Experimente errar para ver ficar vermelho!", color = Color.White)
            Text(
                text = "LOGIN",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            CaixaDeEntrada(
                label = "Usuário",
                placeHolder = "Insira seu usuário",
                value = usuario,
                onValueChange = {
                    usuario = it
                    erroUsuario = false // Reseta o erro ao digitar algo novo
                },
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth(),
                isError = erroUsuario
            )

            CaixaDeEntrada(
                label = "Senha",
                placeHolder = "Digite sua senha",
                value = senha,
                onValueChange = {
                    senha = it
                    erroSenha = false // Reseta o erro ao digitar algo novo
                },
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth(),
                isError = erroSenha
            )

            Spacer(modifier = Modifier.height(24.dp))

            BotaoBonito(
                label = "Entrar",
                onClick = {
                    val usuarioCorreto = "aluno"
                    val senhaCorreta = "1234"

                    erroUsuario = usuario != usuarioCorreto
                    erroSenha = senha != senhaCorreta

                    if (!erroUsuario && !erroSenha) {
                        navController.navigate("menu")
                    }
                },
                color =  Color(0xFFE09132)
            )
        }
    }
}