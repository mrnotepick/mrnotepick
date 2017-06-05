package com.mrnotepick.ui.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.mrnotepick.R
import com.mrnotepick.ui.view.map.GoogleMapController
import com.mrnotepick.ui.view.map.Map
import com.mrnotepick.ui.viewmodel.MapViewModel
import com.mrnotepick.ui.viewmodel.ViewModelFactory
import io.reactivex.Observable

import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment() {

    var viewModel: MapViewModel? = null
    var map: Map? = null

    //// FRAGMENT

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_map, container, false)
    }

    override fun onStart() {
        super.onStart()
        bindViewModel();
        setupViews()
    }

    override fun onStop() {
        super.onStop()
        unbindViewModel()
    }

    //// PRIVATE

    fun bindViewModel() {
        viewModel = ViewModelFactory.provideMapViewModel()
    }

    fun unbindViewModel() {
        viewModel = null
    }

    fun setupViews() {
        // Initialize Google Map
        val supportMapFragment = SupportMapFragment()
        activity.supportFragmentManager.beginTransaction().add(R.id.mapFrameLayout, supportMapFragment).commit()
        supportMapFragment.getMapAsync { setupMap(it) }

        // Setup Note EditText Listener
        Observable.create<String> ({subscriber ->
            noteEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { p0.let { subscriber.onNext(p0.toString()) } }
            })}).subscribe { noteMessage -> viewModel?.noteMessageChanged(noteMessage) }

        // Setup Add Button Listener
        createNoteButton.setOnClickListener { _ -> viewModel?.createNote() }
    }

    fun setupMap(googleMap: GoogleMap) {
        map = GoogleMapController(googleMap)
        map?.mapClicks()?.subscribe { _ ->
            if (noteEditText.visibility == View.GONE) noteEditText.visibility = View.VISIBLE
            else noteEditText.visibility = View.GONE
            if (createNoteButton.visibility == View.GONE) createNoteButton.visibility = View.VISIBLE
            else createNoteButton.visibility = View.GONE }
    }
}












