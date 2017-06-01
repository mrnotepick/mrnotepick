package com.mrnotepick

import com.mrnotepick.data.NoteRepositoryTest
import com.mrnotepick.domain.repository.NoteRepository


class DependencyInjector {

    companion object {

        var noteRepository: NoteRepository? = null

        ////

        fun provideNoteRepository(): NoteRepository {
            if (noteRepository == null) noteRepository = NoteRepositoryTest()
            return noteRepository!!
        }
    }
}