package com.krystianrymonlipinski.dndhelper.data

import com.krystianrymonlipinski.dndhelper.model.CharacterModel
import com.krystianrymonlipinski.dndhelper.room.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    fun retrieveCharacterByName(name: String): Flow<CharacterEntity>
    fun retrieveAllCharacterNames(): Flow<List<String>>
    suspend fun insertCharacter(character: CharacterModel)
    suspend fun updateCharacterName(currentName: String, newName: String)
    suspend fun deleteCharacterWithName(name: String)
}