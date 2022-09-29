package com.developer.pokedexcompose.di

import com.developer.pokedexcompose.data.remote.PokemonApiService
import com.developer.pokedexcompose.repository.PokemonRepository
import com.developer.pokedexcompose.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonApiService
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokemonApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonApiService::class.java)
    }

}