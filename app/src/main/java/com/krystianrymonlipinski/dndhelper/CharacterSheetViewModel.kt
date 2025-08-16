package com.krystianrymonlipinski.dndhelper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krystianrymonlipinski.dndhelper.data.CharacterDataSource
import com.krystianrymonlipinski.dndhelper.model.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
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