package com.mrnotepick.device

import android.content.Context
import android.location.Location
import android.os.Bundle
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.entity.UserLocation
import io.reactivex.Observable
import io.reactivex.Single


class LocationServiceGFA(val context: Context) : LocationService {

    private var locationUpdate: Observable<UserLocation>? = null

    private var isAvailable: Boolean = false

    private var api: GoogleApiClient? = null

    ////

    init {
//        googleApiClient = GoogleApiClient.Builder(context)
//                .addConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks {
//
//                    override fun onConnected(p0: Bundle?) {
//                        locationUpdate = Observable.create<Location> { subscriber ->
//                            LocationServices.FusedLocationApi.requestLocationUpdates(
//                                    googleApiClient,
//                                    createLocationRequest())
//                                    { location -> subscriber.onNext(location) }
//                        }.map { location -> UserLocation(location.latitude, location.longitude)  }
//
//                        println("Connection Success For Google Api Client")
//                    }
//
//                    override fun onConnectionSuspended(p0: Int) {
//                        println("Connection Suspended For Google Api Client")
//                    }
//                })
//                .addOnConnectionFailedListener { _ -> println("Connection Failed For Google Api Client") }
//                .addApi(LocationServices.API)
//                .build()
    }

    //// LOCATION SERVICE

    override fun isAvailable(): Single<Boolean> {
        var status = false
        if (isAvailable) { status = true }
        else {
            api = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks {
                        override fun onConnected(p0: Bundle?) {
                            status = true
                        }

                        override fun onConnectionSuspended(p0: Int) {
                            status = false
                        }
                    })
                    .addOnConnectionFailedListener { status = false }
                    .build()
        }

        return Single.just(status)
    }

    override fun subscribeForUpdate(): Observable<UserLocation> {
        return locationUpdate!!
    }

    //// PRIVATE

    private fun createLocationRequest(): LocationRequest {
        val locationRequest = LocationRequest()
        locationRequest.interval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        return locationRequest
    }
}
























