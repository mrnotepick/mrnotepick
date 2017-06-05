package com.mrnotepick.device

import com.mrnotepick.domain.interactor.InteractorFactory
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class LocationServiceTest {

    companion object {

        fun start() {
            Observable.interval(5, TimeUnit.SECONDS).subscribe {
                InteractorFactory.provideUpdateUserLocationInteractor().execute(1.1, 2.2)
            }
        }
    }
}