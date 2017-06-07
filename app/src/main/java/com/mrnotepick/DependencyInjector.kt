package com.mrnotepick

import android.content.Context
import com.mrnotepick.data.NoteRepositoryT
import com.mrnotepick.device.LocationServiceGFA
import com.mrnotepick.device.LocationServiceT
import com.mrnotepick.domain.LocationService
import com.mrnotepick.domain.repository.NoteRepository


class DependencyInjector {

    companion object {

        var noteRepository: NoteRepository? = null
        var locationService: LocationService? = null

        ////

        fun provideNoteRepository(): NoteRepository {
            if (noteRepository == null) noteRepository = NoteRepositoryT()
            return noteRepository!!
        }

        fun provideLocationService(): LocationService {
            if (locationService == null) locationService = LocationServiceGFA(App.context)
            return locationService!!
        }
    }
}