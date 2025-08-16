package com.krystianrymonlipinski.dndhelper.dependency_injection

import com.krystianrymonlipinski.dndhelper.data.CharacterDataSource
import com.krystianrymonlipinski.dndhelper.room.AppDatabase
import com.krystianrymonlipinski.dndhelper.room.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(ViewModelComponent::class)
class CharacterDataLayerModule {

    @Provides
    fun provideCharacterDataSource(characterDao: CharacterDao) = CharacterDataSource(
        characterDao,
        Dispatchers.IO
    )


    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao = appDatabase.characterDao()

}