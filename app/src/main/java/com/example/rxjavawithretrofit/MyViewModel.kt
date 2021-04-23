package com.example.rxjavawithretrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavawithretrofit.data.PostModel
import com.example.rxjavawithretrofit.data.PostsClient
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MyViewModel:ViewModel() {
    private val TAG = "MyViewModel"
    val postsMutableLiveData = MutableLiveData<List<PostModel>>()

    fun getPosts(){
        val singleObserver = object : SingleObserver<List<PostModel>> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(t: List<PostModel>) {
                postsMutableLiveData.value = t
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: ${e.message}")
            }

        }
      val observable:Single<List<PostModel>> = PostsClient.getInstance().getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        observable.subscribe(singleObserver)

    }
}