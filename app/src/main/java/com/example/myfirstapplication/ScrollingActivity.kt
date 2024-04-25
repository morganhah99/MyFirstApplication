package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    val MyTag = "ScrollingActivity"
    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        Log.d(
            MyTag,
            "OnCreate -> Attaches the UI, prepares the assets to be displayed."
        )
    }


    override fun onStart() {
        super.onStart()
        Log.d(
            MyTag,
            "OnStart -> Allocates the memory for resources, preparing to display UI to the user"
        )
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            MyTag,
            "OnResume -> User can see and interact with the UI"
        ) //only place user gets to interact
    }

    override fun onPause() {
        super.onPause()
        Log.d(
            MyTag,
            "OnPause -> Puts the UI on temporary hold, all the assets are still alive just not visible to the USER"
        )
    }

    override fun onStop() {
        super.onStop()
        Log.d(
            MyTag,
            "OnStop -> Clear/free the memory resources, only exists the reference of elements"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MyTag, "OnDestroy -> Destroys the reference of resources and activity itself")
    }
}