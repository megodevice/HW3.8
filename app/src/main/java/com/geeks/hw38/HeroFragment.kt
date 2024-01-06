package com.geeks.hw38

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw38.databinding.FragmentHeroBinding

class HeroFragment : Fragment() {
private lateinit var binding: FragmentHeroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).toolbar.title = resources.getString(R.string.title_hero_fragment)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(MainActivity.HERO, Hero::class.java)?.apply {
                binding.tvItemHeroName.text = name
                if (status) binding.tvItemHeroStatus.text =
                    binding.root.resources.getString(R.string.status_alive)
                else binding.tvItemHeroStatus.text = binding.root.resources.getString(R.string.status_dead)
                binding.ivItemHeroImage.setImageByURL(imageURL)
            }
        }
    }
}