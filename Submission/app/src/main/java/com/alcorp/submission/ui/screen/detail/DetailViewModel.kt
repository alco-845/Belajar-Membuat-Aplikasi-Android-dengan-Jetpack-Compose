package com.alcorp.submission.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.alcorp.submission.data.ShipRepository

class DetailViewModel(private val repository: ShipRepository) : ViewModel() {
    fun getShipById(id: Int) = repository.getShipById(id)
}