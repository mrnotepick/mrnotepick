package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SubscribeForLocationUpdateInteractor(val locationService: LocationService) {

    fun execute(): Observable<UserLocation> {
        locationService.isAvailable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map { status -> status.toString() }
                .subscribe { status -> println("Connections status - $status") }


        return locationService.subscribeForUpdate()
    }
}
