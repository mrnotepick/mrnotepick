package com.mrnotepick.domain.entity


data class Note(val message: String) {

    fun isInRange(userLocation: UserLocation) = true
}