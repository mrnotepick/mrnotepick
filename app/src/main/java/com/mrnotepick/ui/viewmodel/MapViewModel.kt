package com.mrnotepick.ui.viewmodel

import com.mrnotepick.domain.entity.Location
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

    private fun onLocationUpdated(location: Location) {
        // TODO Check If Note In Range
    }
}