package com.mrnotepick.ui.view

import com.mrnotepick.device.LocationServiceTest


class MainActivity : android.support.v7.app.AppCompatActivity() {

    //// ACTIVITY

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mrnotepick.R.layout.activity_main)

        // TODO Delete Test Code
        LocationServiceTest.start()

        supportFragmentManager.beginTransaction().add(com.mrnotepick.R.id.fragmentContainer, MapFragment()).commit()
    }
}