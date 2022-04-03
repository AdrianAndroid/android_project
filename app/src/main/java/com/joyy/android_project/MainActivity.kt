package com.joyy.android_project

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFE#MainActivity", "onCreate");
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.clickBtn).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE#MainActivity", "onStart");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFE#MainActivity", "onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE#MainActivity", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE#MainActivity", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE#MainActivity", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE#MainActivity", "onDestroy");
    }
}

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFE#SecondActivity", "onCreate");
        setContentView(R.layout.activity_second)
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE#SecondActivity", "onStart");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFE#SecondActivity", "onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE#SecondActivity", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE#SecondActivity", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE#SecondActivity", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE#SecondActivity", "onDestroy");
    }
}



class FirstFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LIFE#FirstFragment", "onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFE#FirstFragment", "onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("LIFE#FirstFragment", "onCreateView");
        return inflater.inflate(R.layout.fragment_blank, container, false)
            .apply { setBackgroundColor(Color.RED) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LIFE#FirstFragment", "onViewCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE#FirstFragment", "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE#FirstFragment", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE#FirstFragment", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE#FirstFragment", "onStop");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LIFE#FirstFragment", "onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE#FirstFragment", "onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LIFE#FirstFragment", "onDetach");
    }
}

class SecondFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LIFE#SecondFragment", "onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFE#SecondFragment", "onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("LIFE#SecondFragment", "onCreateView");
        return inflater.inflate(R.layout.fragment_blank, container, false)
            .apply { setBackgroundColor(Color.GREEN) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LIFE#SecondFragment", "onViewCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE#SecondFragment", "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE#SecondFragment", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE#SecondFragment", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE#SecondFragment", "onStop");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LIFE#SecondFragment", "onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE#SecondFragment", "onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LIFE#SecondFragment", "onDetach");
    }
}

class ThirdFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LIFE#ThirdFragment", "onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFE#ThirdFragment", "onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("LIFE#ThirdFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_blank, container, false)
            .apply { setBackgroundColor(Color.BLUE) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LIFE#ThirdFragment", "onViewCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE#ThirdFragment", "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE#ThirdFragment", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE#ThirdFragment", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE#ThirdFragment", "onStop");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LIFE#ThirdFragment", "onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE#ThirdFragment", "onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LIFE#ThirdFragment", "onDetach");
    }
}