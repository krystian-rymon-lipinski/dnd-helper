package com.krystianrymonlipinski.dndhelper.data

import com.krystianrymonlipinski.dndhelper.model.CharacterBasicsState
import com.krystianrymonlipinski.dndhelper.model.CharacterState
import com.krystianrymonlipinski.dndhelper.room.CharacterDao
import com.krystianrymonlipinski.dndhelper.room.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class CharacterDataSource(
    private val characterDao: CharacterDao,
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

    fun retrieveCharacterByName(name: String): Flow<CharacterEntity> = characterDao
        .retrieveCharacterByName(name)
        .flowOn(coroutineContext)

    fun retrieveAllCharacterNames(): Flow<List<String>> = characterDao
        .retrieveAllCharacterNames()
        .flowOn(coroutineContext)

    suspend fun insertCharacter(character: CharacterEntity) = withContext(coroutineContext) {
        characterDao.insertCharacter(character)
    }

    suspend fun updateCharacter(character: CharacterEntity) = withContext(coroutineContext) {
        characterDao.updateCharacter(character)
    }

    suspend fun deleteCharacter(character: CharacterEntity) = withContext(coroutineContext) {
        characterDao.deleteCharacter(character)
    }
}