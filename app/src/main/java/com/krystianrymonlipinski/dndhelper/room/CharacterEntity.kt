package com.krystianrymonlipinski.dndhelper.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String = "Red",
    @ColumnInfo(name = "level") val level: Int = 1,
    @ColumnInfo(name = "hit_points") val hitPoints: Int = 20,
    @ColumnInfo(name = "armor_class") val armorClass: Int = 12,
    @ColumnInfo(name = "initiative") val initiative: Int = 1,
    @ColumnInfo(name = "speed") val speed: Int = 30
)