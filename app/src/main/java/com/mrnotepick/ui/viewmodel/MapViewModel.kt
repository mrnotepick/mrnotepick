package com.mrnotepick.ui.viewmodel

import com.mrnotepick.domain.entity.UserLocation
import com.mrnotepick.domain.entity.Note
import com.mrnotepick.domain.interactor.InteractorFactory


class MapViewModel {

    private var noteMessage: String = ""

    ////

    init {
        InteractorFactory.provideSubscribeForLocationUpdateInteractor().execute()
                .subscribe { location -> onLocationUpdated(location) }
    }

    ////

    fun noteMessageChanged(note: String) {
        this.noteMessage = note
    }

    fun createNote() {
        InteractorFactory.provideCreateNoteInteractor().execute(noteMessage)
    }

    //// PRIVATE

    private fun onLocationUpdated(userLocation: UserLocation) {
        println("$userLocation")
        InteractorFactory.provideGetNotesInRangeInteractor().execute(userLocation)
                .subscribe { note -> onNoteInRange(note) }
    }

    private fun onNoteInRange(note: Note) {
        println("$note")
    }
}