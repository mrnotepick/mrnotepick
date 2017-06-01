package com.mrnotepick.ui.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.mrnotepick.R
import com.mrnotepick.ui.view.map.GoogleMapController
import com.mrnotepick.ui.view.map.Map

import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment() {

    var map: Map? = null

    //// FRAGMENT

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_map, container, false)
    }

    override fun onStart() {
        super.onStart()
        val supportMapFragment = SupportMapFragment()
        activity.supportFragmentManager.beginTransaction().add(R.id.mapFrameLayout, supportMapFragment).commit()
        supportMapFragment.getMapAsync { setupMap(it) }
    }

    //// PRIVATE

    fun setupMap(googleMap: GoogleMap) {
        map = GoogleMapController(googleMap)
        map?.mapClicks()?.subscribe { _ ->
            if (noteEditText.visibility == View.GONE) noteEditText.visibility = View.VISIBLE
            else noteEditText.visibility = View.GONE }
    }
}