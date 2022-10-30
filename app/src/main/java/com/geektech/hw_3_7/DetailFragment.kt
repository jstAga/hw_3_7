package com.geektech.hw_3_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.geektech.hw_3_7.databinding.FragmentDetailBinding
import com.geektech.hw_3_7.model.Hero


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var position = 0
    private var size = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        size = arguments?.getInt(MainFragment.KEY_SIZE)!!
        position = arguments?.getInt(MainFragment.KEY_POSITION)!!

        setData(position)

        binding.btnBackDetail.setOnClickListener {
            position -= 1
            setData(position)
        }

        binding.btnNextDetail.setOnClickListener {
            position += 1
            setData(position)
        }

    }

    private fun setData(position: Int) {
        val heroList = arguments?.getSerializable(MainFragment.KEY_HERO_LIST) as ArrayList<Hero>?

        binding.tvNameDetail.text = heroList!![position].name
        binding.tvStatusDetail.text = heroList[position].status
        Glide.with(binding.ivAvatarDetail).load(heroList[position].image)
            .into(binding.ivAvatarDetail)

        if (position - 1 < 0) {
            binding.btnBackDetail.visibility = View.GONE
        } else if (position + 1 == size) {
            binding.btnNextDetail.visibility = View.GONE
        } else{
            binding.btnBackDetail.visibility = View.VISIBLE
            binding.btnNextDetail.visibility = View.VISIBLE
        }
    }
}