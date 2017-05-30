package com.mrnotepick.ui.view


class MainActivity : android.support.v7.app.AppCompatActivity() {

    //// ACTIVITY

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mrnotepick.R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(com.mrnotepick.R.id.fragmentContainer, MapFragment()).commit()
    }
}