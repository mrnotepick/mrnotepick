package com.mrnotepick.ui.viewmodel


class ViewModelFactory {

    companion object {

        var mapViewModel: MapViewModel? = null

        ////

        fun provideMapViewModel(): MapViewModel {
            if (mapViewModel == null) mapViewModel = MapViewModel()
            return mapViewModel!!
        }
    }
}