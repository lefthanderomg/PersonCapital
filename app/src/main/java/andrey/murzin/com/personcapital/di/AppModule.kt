package andrey.murzin.com.personcapital.di

import andrey.murzin.com.personcapital.data.repository.ResourceManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideResourceManager(@ApplicationContext context: Context) =
        ResourceManager(context.resources)

    @Singleton
    @Provides
    fun provideIOCoroutineDispatcher() = Dispatchers.IO
}

