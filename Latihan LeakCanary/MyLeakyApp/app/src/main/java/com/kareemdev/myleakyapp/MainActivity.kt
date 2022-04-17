package com.kareemdev.myleakyapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.kareemdev.myleakyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var broadcastReceiver: BroadcastReceiver

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun registerBroadCastReceiver(){
        broadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context, intent: Intent) {
                when(intent.action){
                    Intent.ACTION_POWER_CONNECTED -> {
                        binding.tvPowerStatus.text = getString(R.string.power_connected)
                    }
                    Intent.ACTION_POWER_DISCONNECTED ->{
                        binding.tvPowerStatus.text = getString(R.string.power_disconnect)
                    }
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

}