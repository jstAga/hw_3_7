package com.geektech.hw_3_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.hw_3_7.adapter.HeroAdapter
import com.geektech.hw_3_7.databinding.FragmentMainBinding
import com.geektech.hw_3_7.model.Hero

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var heroList = arrayListOf<Hero>()
    private lateinit var heroAdapter: HeroAdapter

    companion object {
        const val KEY_HERO_LIST = "hero"
        const val KEY_POSITION = "position"
        const val KEY_SIZE = "size"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroList.clear()
        loadData()

        heroAdapter = HeroAdapter(heroList, this::onItemClick)
        binding.rvHero.adapter = heroAdapter
    }


    private fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), position.toString(), Toast.LENGTH_SHORT).show()

        val bundleHero = Bundle()
        bundleHero.putSerializable(KEY_HERO_LIST, heroList)
        bundleHero.putInt(KEY_POSITION, position)
        bundleHero.putInt(KEY_SIZE, heroList.size)

        findNavController().navigate(R.id.detailFragment, bundleHero)
    }

    private fun loadData() {
        heroList.add(Hero("Naruto Uzumaki", "alive", "https://i1.sndcdn.com/artworks-000139163741-dk8qn7-t500x500.jpg"))
        heroList.add(Hero("Jiraiya","dead","https://pbs.twimg.com/media/EDua4dpXsAEGhfX.jpg"))
        heroList.add(Hero("Hidan","???","https://i.pinimg.com/originals/8b/f7/19/8bf71907ab6eaff00a8fd89c2d1546d9.jpg"))
        heroList.add(Hero("Sasuke Uchiha","alive","https://aniyuki.com/wp-content/uploads/2022/04/aniyuki-sasuke-uchiha-avatar-1.jpg"))
        heroList.add(Hero("Might Guy","alive","https://i.pinimg.com/originals/1b/f5/27/1bf527b825107610a52302f81907f273.jpg"))
        heroList.add(Hero("Kakashi Hatake","alive","https://i.pinimg.com/originals/17/b2/86/17b2860d84a83c785f0944296f33310a.jpg"))
        heroList.add(Hero("Gaara","alive","https://avatarfiles.alphacoders.com/322/322318.png"))
        heroList.add(Hero("Minato Namikadze","dead","https://pm1.narvii.com/6286/5034f8e1dee25474cb1f6916e3bcde1cb63f5aae_hq.jpg"))
        heroList.add(Hero("Nara Shikamaru","alive","https://i.pinimg.com/736x/6a/60/c0/6a60c02cdfa4a5aa8deb5c2c25336fbd.jpg"))
        heroList.add(Hero("Deidara","dead","https://i.pinimg.com/736x/de/d0/55/ded05583cc353bebf69f1c258939c2b3.jpg"))
    }
}
