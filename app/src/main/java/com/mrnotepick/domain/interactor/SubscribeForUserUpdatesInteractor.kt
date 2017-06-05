package com.mrnotepick.domain.interactor

import com.mrnotepick.domain.entity.User
import io.reactivex.Observable


class SubscribeForUserUpdatesInteractor {

    fun execute(): Observable<User> {
        return User.getUpdates()
    }
}