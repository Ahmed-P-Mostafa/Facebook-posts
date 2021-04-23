package com.example.rxjavawithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.rxjavawithretrofit.data.PostModel
import com.example.rxjavawithretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    val viewModel = MyViewModel()
    val adapter = PostsAdapter(null)
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recyclerView.adapter = adapter

        viewModel.getPosts()
        viewModel.postsMutableLiveData.observe(this, Observer {
            adapter.changeData(it)
        })
    }
}