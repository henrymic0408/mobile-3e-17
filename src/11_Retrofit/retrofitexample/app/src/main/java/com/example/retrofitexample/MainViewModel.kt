package com.example.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.models.RepositoryResponse
import com.example.retrofitexample.services.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val _listRepository = MutableLiveData<List<RepositoryResponse>>()
    private val _networkState = MutableLiveData<Boolean>()
    private val _statusMessage = MutableLiveData<String>()

    fun searchRepository(username: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GithubService::class.java)
        val repos = service.listRepos(username)

        _networkState.postValue(true)

        repos.enqueue(object : Callback<List<RepositoryResponse>> {
            override fun onResponse(
                call: Call<List<RepositoryResponse>>,
                response: Response<List<RepositoryResponse>>
            ) {
                if (response.isSuccessful) {
                    _listRepository.postValue(response.body())
                    _networkState.postValue(false)
                    _statusMessage.postValue("Berhasil memuat data!")
                }else {
                    _networkState.postValue(false)
                    _statusMessage.postValue("Terjadi kesalahan!")
                }
            }

            override fun onFailure(call: Call<List<RepositoryResponse>>, t: Throwable) {
                _networkState.postValue(false)
                _statusMessage.postValue("Terjadi kesalahan!")
            }
        })
    }

    val listRepository: LiveData<List<RepositoryResponse>> = _listRepository
    val networkState: LiveData<Boolean> = _networkState
    val statusMessage: LiveData<String> = _statusMessage
}