package com.mrnotepick.domain.entity

import io.reactivex.Observable


class User {

    companion object {

        private val updates = Observable.create<User> {}

        private var latitude = 0.0
        private var longitude = 0.0

        ////

        fun updateLocation(latitude: Double, longitude: Double) {
            this.latitude = latitude
            this.longitude = longitude

            // TODO Delete Test Code
            println("New Location: $latitude : $longitude")
        }
    }
}