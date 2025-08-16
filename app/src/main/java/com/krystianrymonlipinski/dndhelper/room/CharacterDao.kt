package com.krystianrymonlipinski.dndhelper.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT name FROM characters")
    fun retrieveAllCharacterNames() : Flow<List<String>>

    @Query("SELECT * FROM characters WHERE name = :name")
    fun retrieveCharacterByName(name: String) : Flow<CharacterEntity>

    @Insert
    fun insertCharacter(character: CharacterEntity)

    @Update
    fun updateCharacter(character: CharacterEntity)

    @Delete
    fun deleteCharacter(character: CharacterEntity)

}