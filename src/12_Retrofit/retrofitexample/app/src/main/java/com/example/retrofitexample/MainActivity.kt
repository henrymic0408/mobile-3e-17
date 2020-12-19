package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexample.adapter.RepositoryAdapter
import com.example.retrofitexample.utils.SnackbarHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        btn_search.setOnClickListener {
            mainViewModel.searchRepository(edt_username.text.toString())
        }

        repositoryAdapter = RepositoryAdapter()

        with(rv_repository) {
            layoutManager = LinearLayoutManager(context)
            adapter = repositoryAdapter
        }

        mainViewModel.listRepository.observe(this, Observer { listRepository ->
            if (listRepository.isNotEmpty()) {
                repositoryAdapter.setList(listRepository)
            }
        })

        mainViewModel.networkState.observe(this, Observer { network ->
            if (network) {
                progress_bar_repository.visibility = View.VISIBLE
                rv_repository.visibility = View.GONE
            }else {
                progress_bar_repository.visibility = View.GONE
                rv_repository.visibility = View.VISIBLE
            }
        })

        mainViewModel.statusMessage.observe(this, Observer { message ->
            SnackbarHelper.showSnackbar(layout_main, message)
        })
    }
}