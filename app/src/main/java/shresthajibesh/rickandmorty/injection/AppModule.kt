package shresthajibesh.rickandmorty.injection

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shresthajibesh.rickandmorty.BuildConfig
import shresthajibesh.rickandmorty.data.remote.RickAndMortyApi
import shresthajibesh.rickandmorty.data.repository.RickAndMortyRepositoryImpl
import shresthajibesh.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): RickAndMortyApi {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickAndMortyRepository(api: RickAndMortyApi): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(api)
    }
}