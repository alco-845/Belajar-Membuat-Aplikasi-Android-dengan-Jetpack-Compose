package com.alcorp.submission.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.alcorp.submission.data.ShipRepository
import com.alcorp.submission.model.Ship
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: ShipRepository) : ViewModel() {
    private val _getShip = MutableStateFlow(
        repository.getShip()
            .sortedBy { it.shipName }
            .groupBy { it.shipName[0] }
    )

    val getShip: StateFlow<Map<Char, List<Ship>>> get() = _getShip

    private val _query = mutableStateOf("")

    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _getShip.value = repository.searchShip(_query.value)
            .sortedBy { it.shipName }
            .groupBy { it.shipName[0] }
    }
}