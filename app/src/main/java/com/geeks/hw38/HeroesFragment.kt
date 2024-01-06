package com.geeks.hw38

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.hw38.databinding.FragmentHeroesBinding

class HeroesFragment : Fragment() {
    private lateinit var binding: FragmentHeroesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).toolbar.title = resources.getString(R.string.title_heroes_fragment)
        binding.rvHeroes.adapter = HeroesAdapter(getData(), this::onItemClick)
    }

    private fun onItemClick(hero: Hero) {
        findNavController().navigate(R.id.heroFragment, bundleOf(MainActivity.HERO to hero))
    }

    private fun getData() : ArrayList<Hero> {
        val list = ArrayList<Hero>()
        list.add(Hero("Eric Theodore Cartman","https://static.wikia.nocookie.net/p__/images/3/30/Eric-Cartman.png/revision/latest/scale-to-width-down/350?cb=20190723211656&path-prefix=protagonist",true))
        list.add(Hero("Stanley William Marsh","https://static.wikia.nocookie.net/p__/images/3/37/StanMarsh-0.png/revision/latest/scale-to-width-down/310?cb=20210126110719&path-prefix=protagonist",true))
        list.add(Hero("Kenneth J. McCormick","https://static.wikia.nocookie.net/p__/images/1/13/KennyMcCormick-0.png/revision/latest/scale-to-width-down/350?cb=20170815071246&path-prefix=protagonist",false))
        list.add(Hero("Kyle M. Broflovski","https://static.wikia.nocookie.net/p__/images/9/95/Kyle-broflovski.png/revision/latest/scale-to-width-down/350?cb=20170810133101&path-prefix=protagonist",true))
        list.add(Hero("Wendy Testaburger","https://static.wikia.nocookie.net/p__/images/8/88/WendyPicture.png/revision/latest/scale-to-width-down/342?cb=20210426132710&path-prefix=protagonist",true))
        list.add(Hero("Leopold Stotch","https://static.wikia.nocookie.net/p__/images/9/99/ButtersStotch-0.png/revision/latest/scale-to-width-down/316?cb=20170810234313&path-prefix=protagonist",true))
        list.add(Hero("Phillip Pirrip","https://static.wikia.nocookie.net/p__/images/c/ca/PhillipPip.png/revision/latest/scale-to-width-down/350?cb=20170812080250&path-prefix=protagonist",true))
        list.add(Hero("Craig Tucker","https://static.wikia.nocookie.net/p__/images/c/c2/Craig-tucker.png/revision/latest/scale-to-width-down/327?cb=20190505120451&path-prefix=protagonist",true))
        list.add(Hero("Barbara Stevens","https://static.wikia.nocookie.net/p__/images/5/5c/2-436-0.png/revision/latest/scale-to-width-down/343?cb=20170812074638&path-prefix=protagonist",true))
        return list
    }
}