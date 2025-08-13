package com.krystianrymonlipinski.dndhelper.data

import com.krystianrymonlipinski.dndhelper.model.CharacterBasicsState
import com.krystianrymonlipinski.dndhelper.model.CharacterState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CharacterSheetDataSource @Inject constructor(
    private val coroutineContext: CoroutineContext
) {
    private val charactersDatabase: Flow<List<CharacterState>> = flowOf(
        listOf(
            CharacterState(basicsState = CharacterBasicsState(name = "Trent")),
            CharacterState(basicsState = CharacterBasicsState(name = "Bob", level = 3)),
            CharacterState(basicsState = CharacterBasicsState(name = "Qouesh")),
            CharacterState(basicsState = CharacterBasicsState(name = "Sameer")),
            CharacterState(basicsState = CharacterBasicsState(name = "Robert")),
            CharacterState(basicsState = CharacterBasicsState(name = "Jack")),
            CharacterState(basicsState = CharacterBasicsState(name = "Qui-San")),
        )
    )

    fun getCharacterByName(name: String): Flow<CharacterState> = charactersDatabase
        .map { characters ->
            characters.single { it.basicsState.name == name } }
        .flowOn(coroutineContext)
}