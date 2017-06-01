package com.mrnotepick.ui.viewmodel

import com.mrnotepick.DependencyInjector
import com.mrnotepick.domain.interactor.CreateNoteInteractor
import com.mrnotepick.domain.interactor.InteractorFactory


class MapViewModel {

    private var messageString: String = ""

    ////

    fun createNote() {
        InteractorFactory.provideCreateNoteInteractor().execute(messageString)
    }
}