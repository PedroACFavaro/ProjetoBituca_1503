package br.com.fiap.prototipo_bituca.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NomeAplicacao(modifier: Modifier = Modifier, color: Color) {
    Text(
        text = "VCR",
        modifier = modifier.padding(top = 10.dp, start = 6.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}
