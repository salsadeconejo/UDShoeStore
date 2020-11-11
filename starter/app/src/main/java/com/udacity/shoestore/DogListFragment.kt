package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.DogItemBinding
import com.udacity.shoestore.databinding.FragmentDogListBinding

class DogListFragment : Fragment() {
    lateinit var binding: FragmentDogListBinding
    lateinit var dogViewModel: DogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dog_list, container, false)

        activity?.apply {
            dogViewModel = ViewModelProvider(this).get(DogViewModel::class.java)
        }
        dogViewModel.dogListLivedata.observe(viewLifecycleOwner, Observer { dogList ->
            dogList.forEach {
                val dogBinding: DogItemBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.dog_item,
                    binding.listContainer,
                    false
                )
                dogBinding.name.text = it.name
                dogBinding.description.text = it.description
                dogBinding.powerLevel.text = it.size.toString()
                dogBinding.company.text = it.company
                dogBinding.imageView.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        it.images[0],
                        context?.theme
                    )
                )
                binding.listContainer.addView(dogBinding.root)
            }
        })

        setHasOptionsMenu(true)

        binding.floatingButton.setOnClickListener {
            findNavController().navigate(DogListFragmentDirections.actionDogListFragmentToDetailFragment())
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }
}
