package dev.jacbes.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dev.jacbes.myapp.fragments.SenderFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "MainActivity: onCreate")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "MainActivity"

        if (savedInstanceState == null) {
            addSenderFragment()
        }
    }

    private fun addSenderFragment() {
        Log.i("LifecycleTag", "MainActivity: addSenderFragment")
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity, SenderFragment())
            .commit()
    }

    override fun onStart() {
        Log.i("LifecycleTag", "MainActivity: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleTag", "MainActivity: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleTag", "MainActivity: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleTag", "MainActivity: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("LifecycleTag", "MainActivity: onDestroy")
        super.onDestroy()
    }

    override fun onBackPressed() {
        Log.i("LifecycleTag", "MainActivity: onBackPressed")
        super.onBackPressed()
    }

}