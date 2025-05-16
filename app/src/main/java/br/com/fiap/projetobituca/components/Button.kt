package br.com.fiap.prototipo_bituca.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotaoBonito(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color
) {
    Spacer(modifier = Modifier.padding(4.dp))
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
    }
}


