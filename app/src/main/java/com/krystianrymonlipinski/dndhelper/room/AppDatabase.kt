package com.krystianrymonlipinski.dndhelper.room

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
class AppDatabase : RoomDatabase() {
    override fun clearAllTables() {

    }

    override fun createInvalidationTracker(): InvalidationTracker {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        throw UnsupportedOperationException("Not yet implemented")
    }

}