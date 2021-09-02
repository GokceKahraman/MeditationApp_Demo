package com.example.meditationapp_demo.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp_demo.databinding.ItemMeditationBinding
import com.example.meditationapp_demo.databinding.ItemStoryBinding
import com.example.meditationapp_demo.databinding.ItemTitleBinding
import com.example.meditationapp_demo.ui.adapters.types.*
import com.example.meditationapp_demo.ui.holders.BaseViewHolder

class HomeAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var list: ArrayList<BaseListItem> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TYPE_TITLE -> HomeTitleHolder(ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_STORY -> HomeStoryHolder(ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            //TYPE_BANNER -> HomeBannerHolder()
            TYPE_MEDITATION -> HomeMeditationHolder(ItemMeditationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> HomeTitleHolder(ItemTitleBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = list.size

    //Home page view
    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is TitleListItem -> TYPE_TITLE
            is MeditationListItem -> TYPE_MEDITATION
            is BannerListItem -> TYPE_BANNER
            is StoryListItem -> TYPE_STORY
            else -> -1
        }
    }

    inner class HomeTitleHolder(private val binding: ItemTitleBinding) :
        BaseViewHolder(binding.root) {
        override fun bind() {
            binding.title = (list[adapterPosition] as TitleListItem).title
        }
    }


    inner class HomeStoryHolder(private val binding: ItemStoryBinding) :
        BaseViewHolder(binding.root) {
        override fun bind() {
            binding.story = (list[adapterPosition] as StoryListItem).story
        }
    }

   // inner class HomeBannerHolder(private val binding: ItemBannerBinding) :





    inner class HomeMeditationHolder(private val binding: ItemMeditationBinding) :
        BaseViewHolder(binding.root) {
        override fun bind() {
           // binding.
        }
    }




    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_MEDITATION = 1
        const val TYPE_BANNER = 2
        const val TYPE_STORY = 3
    }
}