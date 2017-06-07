package com.mrnotepick.domain

import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable


interface LocationService {

    fun subscribeForUpdate(): Observable<UserLocation>
}