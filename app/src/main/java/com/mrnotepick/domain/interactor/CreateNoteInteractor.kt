package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.entity.Note
import com.mrnotepick.domain.repository.NoteRepository


class CreateNoteInteractor(val noteRepository: NoteRepository) {

    fun execute(message: String) {
        noteRepository.add(Note(message))
    }
}