package com.mrnotepick.ui.viewmodel

import com.mrnotepick.domain.interactor.CreateNoteInteractor


class MapViewModel {

    fun createNote() {
        val interactor = CreateNoteInteractor()
    }
}