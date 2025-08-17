package com.krystianrymonlipinski.dndhelper

import androidx.lifecycle.ViewModel
import com.krystianrymonlipinski.dndhelper.data.CharacterDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterSheetViewModel @Inject constructor(
    characterSheetDataSource: CharacterDataSource
) : ViewModel()  {
/*
    val chosenCharacterState: StateFlow<CharacterState> = characterSheetDataSource.retrieveCharacterByName("Bob").stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 500),
        initialValue = CharacterState()
    )

 */

}