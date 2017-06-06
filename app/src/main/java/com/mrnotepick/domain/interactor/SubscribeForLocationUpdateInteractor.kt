package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.entity.Location
import io.reactivex.Observable


class SubscribeForLocationUpdateInteractor(val locationService: LocationService) {

    fun execute(): Observable<Location> {
        return locationService.subscribeForUpdate()
    }
}
