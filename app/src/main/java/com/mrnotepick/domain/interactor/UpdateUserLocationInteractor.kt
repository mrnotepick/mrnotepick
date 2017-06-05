package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.entity.User


class UpdateUserLocationInteractor {

    fun execute(latitude: Double, longitude: Double) {
        User.updateLocation(latitude, longitude)
    }
}