package com.krystianrymonlipinski.dndhelper

import androidx.lifecycle.ViewModel
import com.krystianrymonlipinski.dndhelper.model.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterSheetViewModel @Inject constructor() : ViewModel()  {

    val state: CharacterState = CharacterState()
}