package com.example.anime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler.Callback
import android.telecom.Call.Details
import androidx.recyclerview.widget.RecyclerView
import com.example.anime.databinding.ActivityMainBinding
import com.example.anime.databinding.AnimekBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var AnimekList:ArrayList<DataItem>
    private lateinit var AnimekRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AnimekList = arrayListOf<DataItem>()

        with(binding){
            val AnimeService=AnimeApiService().getInstance()
            val response=AnimeService.create(AnimeApiInterface::class.java).getAnimeList()

            response.enqueue(object : retrofit2.Callback<Animek> {
                override fun onResponse(call: Call<Animek>, response: Response<Animek>) {
                    if (response.isSuccessful) {
                        val movieResponse = response.body()
                        val movies = movieResponse?.data
                        if (movies != null) {
                            for (anime in movies) {
                                val newDataMovie = DataItem(
                                    anime?.date,
                                    anime?.entry,
                                    anime?.malId,
                                    anime?.user,
                                    anime?.content
                                )
                                AnimekList.add(newDataMovie)
                            }
                            AnimekRecyclerView=animek
                            val adapter=AnimekAdapter(AnimekList){
                                animekClicked->
                                val intent=Intent(this@MainActivity,MainActivity2::class.java)
                                intent.putExtra("title",animekClicked.entry?.get(0)?.title.toString())
                                intent.putExtra("imek",animekClicked.entry?.get(0)?.images?.jpg?.imageUrl.toString())
                                intent.putExtra("des",animekClicked.content)
                                startActivity(intent)
                            }
                            AnimekRecyclerView.adapter=adapter
                        }
                    } else {
                    }
                }

                override fun onFailure(call: Call<Animek>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}