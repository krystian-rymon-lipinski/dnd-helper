package com.krystianrymonlipinski.dndhelper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krystianrymonlipinski.dndhelper.data.CharacterSheetDataSource
import com.krystianrymonlipinski.dndhelper.model.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharacterSheetViewModel @Inject constructor(
    characterSheetDataSource: CharacterSheetDataSource
) : ViewModel()  {

    val chosenCharacterState: StateFlow<CharacterState> = characterSheetDataSource.getCharacterByName("Bob").stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 500),
        initialValue = CharacterState()
    )

}