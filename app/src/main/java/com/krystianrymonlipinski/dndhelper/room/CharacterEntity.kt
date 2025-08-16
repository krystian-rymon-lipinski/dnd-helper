package com.krystianrymonlipinski.dndhelper.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "level") val level: Int,
    @ColumnInfo(name = "hit_points") val hitPoints: Int,
    @ColumnInfo(name = "armor_class") val armorClass: Int,
    @ColumnInfo(name = "initiative") val initiative: Int,
    @ColumnInfo(name = "speed") val speed: Int
)