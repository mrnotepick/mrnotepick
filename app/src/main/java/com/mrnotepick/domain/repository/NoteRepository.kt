package com.mrnotepick.domain.repository

import com.mrnotepick.domain.entity.Note
import io.reactivex.Observable


interface NoteRepository {

    fun add(note: Note)

    fun queryNotes(): Observable<Note>
}