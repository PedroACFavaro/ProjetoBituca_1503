package br.com.fiap.projetobituca.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.projetobituca.R

@Composable
fun LogoTopRight() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp) // Ajuste a margem conforme necessário
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Substitua 'sua_logo' pelo nome real do seu drawable
            contentDescription = "Logo",
            modifier = Modifier
                .size(60.dp) // Ajuste o tamanho conforme necessário
                .align(Alignment.TopEnd)
                .clip(CircleShape)

        )
    }
}
