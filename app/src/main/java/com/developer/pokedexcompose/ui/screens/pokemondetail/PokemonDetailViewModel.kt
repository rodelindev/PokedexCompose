package com.developer.pokedexcompose.ui.screens.pokemondetail

import androidx.lifecycle.ViewModel
import com.developer.pokedexcompose.data.remote.responses.Pokemon
import com.developer.pokedexcompose.repository.PokemonRepository
import com.developer.pokedexcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}