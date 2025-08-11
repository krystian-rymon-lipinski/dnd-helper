package com.krystianrymonlipinski.dndhelper.ui.character_sheet

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krystianrymonlipinski.dndhelper.R

@Composable
fun CharacterSheetScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        RowTitle(stringRes = R.string.basics_title, modifier = modifier)
        CharacterBasics()
        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        RowTitle(stringRes = R.string.ability_scores_title, modifier = modifier)
        CharacterAbilityScores()
        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
    }
}


@Composable
fun CharacterBasics(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.15f)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumberWithTextVertically(number = 0, text = stringResource(id = R.string.stat_hp))
        NumberWithTextVertically(number = 0, text = stringResource(id = R.string.stat_ac))
        NumberWithTextVertically(number = 0, text = stringResource(id = R.string.stat_initiative))
        NumberWithTextVertically(number = 0, text = stringResource(id = R.string.stat_speed))
    }
}

@Composable
fun CharacterAbilityScores() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.15f)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val strength = 16
        val dexterity = 14
        val constitution = 15
        val intelligence = 12
        val wisdom = 10
        val charisma = 8

        NumberWithTextVertically(number = strength, text = stringResource(id = R.string.ability_str))
        NumberWithTextVertically(number = dexterity, text = stringResource(id = R.string.ability_dex))
        NumberWithTextVertically(number = constitution, text = stringResource(id = R.string.ability_con))
        NumberWithTextVertically(number = intelligence, text = stringResource(id = R.string.ability_int))
        NumberWithTextVertically(number = wisdom, text = stringResource(id = R.string.ability_wis))
        NumberWithTextVertically(number = charisma, text = stringResource(id = R.string.ability_cha))
    }
}


@Composable
fun RowTitle(@StringRes stringRes: Int, modifier: Modifier) {
    Text(
        text = stringResource(id = stringRes),
        modifier = modifier.absoluteOffset(x = 16.dp, y = 8.dp),
        style = MaterialTheme.typography.headlineSmall
            .copy(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun NumberWithTextVertically(
    number: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterSheetScreenPreview() {
    CharacterSheetScreen()
}
