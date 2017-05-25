package com.mrnotepick

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment

class MapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_map, container, false)
    }

    override fun onStart() {
        super.onStart()
        val supportMapFragment = SupportMapFragment()
        activity.supportFragmentManager.beginTransaction().add(R.id.mapFrameLayout, supportMapFragment).commit()
        supportMapFragment.getMapAsync { println("Map Initialized") }
    }
}