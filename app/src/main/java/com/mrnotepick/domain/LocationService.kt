package com.mrnotepick.domain

import com.mrnotepick.domain.entity.Location
import io.reactivex.Observable


interface LocationService {

    fun subscribeForUpdate(): Observable<Location>
}