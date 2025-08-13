package com.krystianrymonlipinski.dndhelper.dependency_injection

import com.krystianrymonlipinski.dndhelper.data.CharacterSheetDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(ViewModelComponent::class)
class CharacterSheetViewModelModule {

    @Provides
    fun provideCharacterSheetDataSource() = CharacterSheetDataSource(provideIoCoroutineContext())

    @Provides
    fun provideIoCoroutineContext() = Dispatchers.IO


}