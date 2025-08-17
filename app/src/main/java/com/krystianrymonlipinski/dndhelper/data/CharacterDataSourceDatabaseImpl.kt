package com.krystianrymonlipinski.dndhelper.data

import com.krystianrymonlipinski.dndhelper.model.CharacterModel
import com.krystianrymonlipinski.dndhelper.room.CharacterDao
import com.krystianrymonlipinski.dndhelper.room.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class CharacterDataSourceDatabaseImpl(
    private val characterDao: CharacterDao,
    private val coroutineContext: CoroutineContext
) : CharacterDataSource {

    override fun retrieveCharacterByName(name: String): Flow<CharacterEntity> = characterDao
        .retrieveCharacterByName(name)
        .flowOn(coroutineContext)

    override fun retrieveAllCharacterNames(): Flow<List<String>> = characterDao
        .retrieveAllCharacterNames()
        .flowOn(coroutineContext)

    override suspend fun insertCharacter(character: CharacterModel) = withContext(coroutineContext) {
        characterDao.insertCharacter(character.migrateToEntity())
    }

    override suspend fun updateCharacterName(currentName: String, newName: String) = withContext(coroutineContext) {
        characterDao.updateCharacterName(currentName, newName)
    }

    override suspend fun deleteCharacterWithName(name: String) = withContext(coroutineContext) {
        characterDao.deleteCharacterWithName(name)
    }

    fun CharacterModel.migrateToEntity() = CharacterEntity(
        name = this.name,
        level = this.level,
        hitPoints = this.hitPoints,
        armorClass = this.armorClass,
        initiative = this.initiative,
        speed = this.speed
    )
}