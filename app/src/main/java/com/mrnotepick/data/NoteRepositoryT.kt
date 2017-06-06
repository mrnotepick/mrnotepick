package com.mrnotepick.data

import com.mrnotepick.domain.entity.Note
import com.mrnotepick.domain.repository.NoteRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.util.*


class NoteRepositoryT : NoteRepository {

    val notes = ArrayList<Note>()

    //// NOTE REPOSITORY

    override fun add(note: Note) {
        notes.add(note)
    }
}