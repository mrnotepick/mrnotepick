package com.mrnotepick.data

import com.mrnotepick.domain.entity.Note
import com.mrnotepick.domain.repository.NoteRepository
import java.util.ArrayList


class NoteRepositoryTest : NoteRepository {

    val notes = ArrayList<Note>()

    //// NOTE REPOSITORY

    override fun add(note: Note) {
        notes.add(note)
    }
}