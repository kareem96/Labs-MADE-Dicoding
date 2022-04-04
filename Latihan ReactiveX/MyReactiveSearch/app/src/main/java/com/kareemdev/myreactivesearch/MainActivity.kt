package com.kareemdev.myreactivesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.kareemdev.myreactivesearch.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val viewModel : MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

//        val edPlace
        binding.edPlace.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lifecycleScope.launch { viewModel.queryChannel.send(s.toString()) }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewModel.searchResult.observe(this, Observer { placesitem ->
            val placeName = arrayListOf<String?>()
            placesitem.map { placeName.add(it.placeName) }
            val adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placeName)
            adapter.notifyDataSetChanged()
            binding.edPlace.setAdapter(adapter)
        })
    }
}