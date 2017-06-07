package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.entity.UserLocation
import com.mrnotepick.domain.repository.NoteRepository


class GetNotesInRangeInteractor(val noteRepository: NoteRepository) {

    fun execute(userLocation: UserLocation) = noteRepository.queryNotes()
            .filter { note -> note.isInRange(userLocation) }!!
}