package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable


class SubscribeForLocationUpdateInteractor(val locationService: LocationService) {

    fun execute(): Observable<UserLocation> {
        return locationService.subscribeForUpdate()
    }
}
