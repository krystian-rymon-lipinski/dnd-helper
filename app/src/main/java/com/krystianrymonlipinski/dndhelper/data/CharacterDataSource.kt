package com.krystianrymonlipinski.dndhelper.data

import com.krystianrymonlipinski.dndhelper.room.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

interface CharacterDataSource {

    fun retrieveCharacterByName(name: String): Flow<CharacterEntity>
    fun retrieveAllCharacterNames(): Flow<List<String>>
    suspend fun insertCharacter(character: CharacterEntity)
    suspend fun updateCharacter(character: CharacterEntity)
    suspend fun deleteCharacter(character: CharacterEntity)
}