package com.mrnotepick.ui.view.map

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable


interface Map {

    fun mapClicks(): Observable<LatLng>
}