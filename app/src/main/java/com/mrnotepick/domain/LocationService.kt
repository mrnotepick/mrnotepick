package com.mrnotepick.domain

import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable
import io.reactivex.Single


interface LocationService {

    fun isAvailable(): Single<Boolean>

    fun subscribeForUpdate(): Observable<UserLocation>
}