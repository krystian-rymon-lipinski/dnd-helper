package com.krystianrymonlipinski.dndhelper.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT name FROM characters")
    fun retrieveAllCharacterNames() : Flow<List<String>>

    @Query("SELECT * FROM characters WHERE name = :name")
    fun retrieveCharacterByName(name: String) : Flow<CharacterEntity>

    @Insert
    fun insertCharacter(character: CharacterEntity)

    @Query("UPDATE characters SET name = :newName WHERE name = :currentName")
    fun updateCharacterName(currentName: String, newName: String)

    @Query("DELETE FROM characters WHERE name = :name")
    fun deleteCharacterWithName(name: String)

}