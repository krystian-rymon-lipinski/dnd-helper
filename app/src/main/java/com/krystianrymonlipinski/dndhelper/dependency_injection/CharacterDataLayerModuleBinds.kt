package com.krystianrymonlipinski.dndhelper.dependency_injection

import com.krystianrymonlipinski.dndhelper.data.CharacterDataSource
import com.krystianrymonlipinski.dndhelper.data.CharacterDataSourceDatabaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharacterDataLayerModuleBinds {

    @Binds
    abstract fun bindCharacterDataSource(characterDataSourceDatabaseImpl: CharacterDataSourceDatabaseImpl): CharacterDataSource
}