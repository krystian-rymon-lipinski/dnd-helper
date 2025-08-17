package com.krystianrymonlipinski.dndhelper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krystianrymonlipinski.dndhelper.data.CharacterDataSource
import com.krystianrymonlipinski.dndhelper.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCharactersScreenViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource
): ViewModel() {

    val charactersState: StateFlow<List<String>> = characterDataSource.retrieveAllCharacterNames().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = emptyList()
    )

    fun addCharacterWithOnlyName(name: String) = addCharacter(CharacterModel(name = name))

    fun addCharacter(characterModel: CharacterModel) {
        viewModelScope.launch {
            characterDataSource.insertCharacter(characterModel)
        }
    }

    fun updateCharacterName(currentName: String, newName: String) {
        viewModelScope.launch {
            characterDataSource.updateCharacterName(currentName, newName)

        }
    }

    fun deleteCharacterWithName(name: String) {
        viewModelScope.launch {
            characterDataSource.deleteCharacterWithName(name)

        }
    }

}