package com.krystianrymonlipinski.dndhelper.ui.character_sheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CharacterSheetScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello World from CharacterSheetScreen!")
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterSheetScreenPreview() {
    CharacterSheetScreen()
}
