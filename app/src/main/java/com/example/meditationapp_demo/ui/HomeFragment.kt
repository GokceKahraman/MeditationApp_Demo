package com.example.meditationapp_demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meditationapp_demo.data.ApiInterface
import com.example.meditationapp_demo.databinding.FragmentHomeDesignBinding
import com.example.meditationapp_demo.model.DataClass
import com.example.meditationapp_demo.ui.adapters.HomeAdapter
import com.example.meditationapp_demo.ui.adapters.types.BannerListItem
import com.example.meditationapp_demo.ui.adapters.types.BaseListItem
import com.example.meditationapp_demo.ui.adapters.types.StoryListItem
import com.example.meditationapp_demo.ui.adapters.types.TitleListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeDesignBinding
    private val adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeDesignBinding.inflate(inflater)
        return binding.root
    }


    //sharedPreferences.getString("userNamePreferences", "").toString()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeRecycler.apply {



            //vertical recyclerview


            //GridLayout shows 2 in a row.
            val gridLayoutManager = GridLayoutManager(requireContext(), 2)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (this@HomeFragment.adapter.getItemViewType(position) == HomeAdapter.TYPE_STORY) {
                        1
                    } else {
                        2
                    }
                }

            }
            layoutManager = gridLayoutManager



            adapter = this@HomeFragment.adapter
        }

        getData()
    }


    //https://jsonblob.com/api/        jsonBlob/880820375799373824

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonblob.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ApiInterface = retrofit.create(ApiInterface::class.java)

        service.listData("880820375799373824")
            .enqueue(object : Callback<DataClass> {
                override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                    if (response.isSuccessful) {
                        val list: ArrayList<BaseListItem> = arrayListOf()

                        response.body()?.apply {
                            if (meditations.size > 0) {
                                list.add(TitleListItem("Meditations"))
                                // list.add(MeditationListItem(meditations))
                            }
                             if (isBannerEnabled) {
                                 list.add(BannerListItem())
                             }
                            if (stories.size > 0) {
                                list.add(TitleListItem("Stories"))
                                stories.forEach {
                                    list.add(StoryListItem(it))
                                }
                            }
                            adapter.list = list
                        }
                    }
                }

                override fun onFailure(call: Call<DataClass>, t: Throwable) {
                }
            })
    }
}