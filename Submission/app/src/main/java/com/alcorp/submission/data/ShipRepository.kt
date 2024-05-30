package com.alcorp.submission.data

import com.alcorp.submission.model.FakeShipDataSource
import com.alcorp.submission.model.Ship

class ShipRepository() {

    fun getShip(): List<Ship> {
        return FakeShipDataSource.ships
    }

    fun searchShip(query: String): List<Ship>{
        return FakeShipDataSource.ships.filter {
            it.shipName.contains(query, ignoreCase = true)
        }
    }

    fun getShipById(id: Int): Ship {
        return FakeShipDataSource.ships.first {
            it.id == id
        }
    }
}