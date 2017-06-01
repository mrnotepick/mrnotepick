package com.mrnotepick.ui.view.map

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable


class GoogleMapController(val map: GoogleMap) : Map {

    val mapClicks = Observable.create<LatLng> ({ subscriber -> map.setOnMapClickListener { coordinates -> subscriber.onNext(coordinates) }})

    //// MAP

    override fun mapClicks(): Observable<LatLng> {
        return mapClicks
    }
}