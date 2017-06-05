package com.mrnotepick.ui.viewmodel

import com.mrnotepick.domain.interactor.InteractorFactory


class MapViewModel {

    private var noteMessage: String = ""

    ////

    fun noteMessageChanged(note: String) {
        this.noteMessage = note
    }

    fun createNote() {
        InteractorFactory.provideCreateNoteInteractor().execute(noteMessage)
    }
}