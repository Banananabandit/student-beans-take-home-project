package com.example.sbtechincaltest.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sbtechincaltest.GetInitialOffersUseCase
import com.example.sbtechincaltest.OffersRepository
import com.example.sbtechincaltest.OffersScreenState
import com.example.sbtechincaltest.ToggleFavouriteUseCase
import kotlinx.coroutines.*

class OffersViewModel(): ViewModel() {
    private val repository = OffersRepository()
    private val getInitialOffersUseCase = GetInitialOffersUseCase() // Here we are grabbing dependency on the use case
    private val toggleFavouriteUseCase = ToggleFavouriteUseCase()
    private val _state = mutableStateOf(OffersScreenState(offers = listOf(), isLoading = true))
    val state: State<OffersScreenState> get() = _state
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(
            error = exception.message,
            isLoading = false
        )
    }

    init {
        getOffers()
    }

    // TODO: implement timeout and retry logic. Also ensure this method is cooperative with cancellation
    private fun getOffers() {
        viewModelScope.launch(exceptionHandler) {
            val offers = getInitialOffersUseCase.invoke() // instead of repository.getAllOffers()
            _state.value = _state.value.copy(
                offers = offers,
                isLoading = false
            )
        }
    }

    fun toggleFavorite(id: Int, oldValue: Boolean) {
        viewModelScope.launch {
            val updatedOffers = toggleFavouriteUseCase(id, oldValue)
            _state.value = _state.value.copy(offers = updatedOffers)
        }
    }


}