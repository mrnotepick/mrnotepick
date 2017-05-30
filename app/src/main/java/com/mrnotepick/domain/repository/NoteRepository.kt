package com.mrnotepick.domain.repository

import com.mrnotepick.domain.entity.Note


interface NoteRepository {

    fun add(note: Note)
}