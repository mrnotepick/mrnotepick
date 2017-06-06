package com.mrnotepick.domain.interactor

import com.mrnotepick.DependencyInjector


class InteractorFactory {

    companion object {

        fun provideCreateNoteInteractor(): CreateNoteInteractor {
            return CreateNoteInteractor(DependencyInjector.provideNoteRepository())
        }

        fun provideSubscribeForLocationUpdateInteractor(): SubscribeForLocationUpdateInteractor {
            return SubscribeForLocationUpdateInteractor(DependencyInjector.provideLocationService())
        }
    }
}