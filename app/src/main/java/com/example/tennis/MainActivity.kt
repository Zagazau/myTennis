package com.example.mytennis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytennis.TorneioAdapter
import com.example.mytennis.databinding.ActivityMainBinding
import com.example.tennis.services.TorneioService
import kotlinx.coroutines.*
import mytennis.api.core.RequestResult
import responses.torneios.GetAllTorneiosResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)
    }

}
