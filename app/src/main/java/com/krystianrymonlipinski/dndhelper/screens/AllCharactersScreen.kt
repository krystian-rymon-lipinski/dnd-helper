    package com.krystianrymonlipinski.dndhelper.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.krystianrymonlipinski.dndhelper.AllCharactersScreenViewModel

@Composable
fun AllCharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: AllCharactersScreenViewModel = hiltViewModel()
) {
    val screenState = viewModel.charactersState.collectAsStateWithLifecycle()

    var showCreateCharacterDialog by rememberSaveable { mutableStateOf(false) }
    var showEditNameDialog by rememberSaveable { mutableStateOf(false) }
    var showDeleteCharacterDialog by rememberSaveable { mutableStateOf(false) }

    var currentlyChosenName: String? by rememberSaveable { mutableStateOf(null) }

    if (screenState.value.isNotEmpty()) ScreenWithCharacterNames(
        modifier.fillMaxSize(),
        screenState.value,
        onUpdateClicked = { chosenName ->
            currentlyChosenName = chosenName
            showEditNameDialog = true
        },
        onDeleteClicked = { chosenName ->
            currentlyChosenName = chosenName
            showDeleteCharacterDialog = true
        }
    ) else ScreenWithTextAndButton(
        modifier.fillMaxSize(),
        onAddClicked = { showCreateCharacterDialog = true }
    )

    if (showCreateCharacterDialog) {
        EditNameDialog(
            modifier = modifier,
            currentName = "",
            onConfirmClicked = { characterName ->
                showCreateCharacterDialog = false
                viewModel.addCharacterWithOnlyName(characterName)
            },
            onDismissClicked = { showCreateCharacterDialog = false })
    }

    if (showEditNameDialog) {
        EditNameDialog(
            modifier = modifier,
            currentName = currentlyChosenName ?: "",
            onConfirmClicked = { newName ->
                showEditNameDialog = false
                viewModel.updateCharacterName(currentlyChosenName ?: "", newName)
            },
            onDismissClicked = {
                showEditNameDialog = false
                currentlyChosenName = null
            })
    }

    if (showDeleteCharacterDialog) {
        DeleteCharacterDialog(
            onConfirmClicked = {
                showDeleteCharacterDialog = false
                viewModel.deleteCharacterWithName(currentlyChosenName ?: "")
            },
            onDismissClicked = {
                showDeleteCharacterDialog = false
                currentlyChosenName = null
            })
    }
}

@Composable
fun ScreenWithCharacterNames(
    modifier: Modifier = Modifier,
    characterNames: List<String> = emptyList(),
    onUpdateClicked: (String) -> Unit = {},
    onDeleteClicked: (String) -> Unit = {}
) {


    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        items(count = characterNames.size) { index ->
            CharacterRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                name = characterNames[index],
                onUpdateClicked = { onUpdateClicked(characterNames[index]) },
                onDeleteClicked = { onDeleteClicked(characterNames[index]) }
            )
        }
    }
}

@Composable
fun EditNameDialog(
    modifier: Modifier = Modifier,
    currentName: String = "Bob",
    onConfirmClicked: (String) -> Unit = {},
    onDismissClicked: () -> Unit = {}
) {
    var currentNameState by rememberSaveable { mutableStateOf(currentName) }

    Dialog(onDismissRequest = onDismissClicked) {
        Card(
            modifier.fillMaxWidth(1f).wrapContentHeight()
        ) {
            Box() {
                Column(

                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "Character's name"
                    )
                    TextField(
                        modifier = Modifier.padding(16.dp),
                        value = currentNameState,
                        onValueChange = { newValue ->
                            currentNameState = newValue
                        }
                    )
                    DialogRowWithButtons(
                        onConfirmClicked = {
                            onConfirmClicked(currentNameState)
                        },
                        onDismissCLicked = onDismissClicked
                    )
                }
            }
        }
    }
}

@Composable
fun DeleteCharacterDialog(
    onConfirmClicked: () -> Unit = {},
    onDismissClicked: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismissClicked) {
        Card {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Delete character?"
                )
                DialogRowWithButtons(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onConfirmClicked = {
                        onConfirmClicked()
                    }
                )
            }
        }
    }
}

@Composable
fun DialogRowWithButtons(
    modifier: Modifier = Modifier,
    onConfirmClicked: () -> Unit = {},
    onDismissCLicked: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { onConfirmClicked() }) {
            Text(text = "Confirm")
        }
        Button(onClick = { onDismissCLicked() }) {
            Text(text = "Cancel")
        }
    }
}

@Composable
fun CharacterRow(
    modifier: Modifier = Modifier,
    name: String = "Bob",
    onUpdateClicked: (String) -> Unit = {},
    onDeleteClicked: (String) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(1f)
        )
        ControlIcons(
            onUpdateClicked = { onUpdateClicked(name) },
            onDeleteClicked = { onDeleteClicked(name) }
        )
    }
}

@Composable
fun ControlIcons(
    onUpdateClicked: () -> Unit = {},
    onDeleteClicked: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onUpdateClicked() }) {
            Icon(imageVector = Icons.Filled.Edit, contentDescription = "Update Character")
        }
        IconButton(onClick = { onDeleteClicked() }) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Character")
        }
    }
}

@Composable
fun ScreenWithTextAndButton(
    modifier: Modifier = Modifier,
    onAddClicked: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "No characters created yet")
            IconButton(onClick = { onAddClicked() }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Delete Character")
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScreenWithCharacterNamesPreview() {
    ScreenWithCharacterNames(characterNames = listOf("The One", "Vix Machena", "Reos", "Pathos", "Etcetera Long Name That Might Cause Issues"))
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CharacterRowPreview() {
    MaterialTheme {
        CharacterRow()
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScreenWithTextAndButtonPreview() {
    MaterialTheme {
        ScreenWithTextAndButton()
    }
}