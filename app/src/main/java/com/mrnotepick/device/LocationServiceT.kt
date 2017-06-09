package com.mrnotepick.device

import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit


class LocationServiceT : LocationService {

    private val locationUpdate = Observable.interval(5, TimeUnit.SECONDS)
            .map { i -> UserLocation(i.toDouble(), i.toDouble()) }

    //// LOCATION SERVICE

    override fun isAvailable(): Single<Boolean> {
        return Single.just(true)
    }

    override fun subscribeForUpdate(): Observable<UserLocation> {
        return locationUpdate
    }
}