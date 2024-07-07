import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytennis.TorneioAdapter
import com.example.tennis.services.TorneioService
import kotlinx.coroutines.*
import missing.namespace.databinding.ActivityMainBinding
import mytennis.api.core.RequestResult
import responses.torneios.GetAllTorneiosResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var torneioService: TorneioService
    private lateinit var adapter: TorneioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView
        adapter = TorneioAdapter(emptyList())
        binding.recyclerViewTorneios.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTorneios.adapter = adapter

        // Configurar Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.seuservico.com/") // URL base do seu serviço
            .addConverterFactory(GsonConverterFactory.create()) // Converter factory para Gson
            .build()

        torneioService = retrofit.create(TorneioService::class.java)

        // Chamar o serviço para obter torneios
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = getTorneios()

                if (result is RequestResult.Success) {
                    adapter.updateTorneios(result.data.torneios)
                } else if (result is RequestResult.Error) {
                    // Tratar erro
                    println("Erro na requisição: ${result.message}")
                }
            } catch (e: Exception) {
                // Tratar exceções
                println("Erro ao executar requisição: ${e.message}")
            }
        }
    }

    private suspend fun getTorneios(): RequestResult<GetAllTorneiosResponse> {
        var map: Map<String, String> = emptyMap();
        return try {
            val response = torneioService.getTorneios()
            return response;
        } catch (e: Exception) {
            RequestResult.Error(
                code = 400,

                message = "Erro ao executar requisição: ${e.message}",
                errors = map)
        }
    }
}
