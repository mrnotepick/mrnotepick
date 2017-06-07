package com.mrnotepick.data

import com.mrnotepick.domain.entity.Note
import com.mrnotepick.domain.repository.NoteRepository
import io.reactivex.Observable
import java.util.*


class NoteRepositoryT : NoteRepository {

    val notes = ArrayList<Note>()

    //// NOTE REPOSITORY

    override fun add(note: Note) {
        notes.add(note)
    }

    override fun queryNotes() = Observable.fromIterable(notes)!!
}