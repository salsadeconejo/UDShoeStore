package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var dogViewModel: DogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.let {
            dogViewModel = ViewModelProvider(it).get(DogViewModel::class.java)
        }

        val binding =
            DataBindingUtil.inflate<FragmentDetailBinding>(
                inflater,
                R.layout.fragment_detail,
                container,
                false
            )
        binding.dogViewModel = dogViewModel
        binding.fragment = this
        binding.lifecycleOwner = this

        dogViewModel.addDogResult.observe(this, {
            saveDog(it)
        })
        setHasOptionsMenu(true)

        return binding.root
    }

    fun saveDog(isDogSaved: Boolean) {
        if (isDogSaved) {
            Toast.makeText(
                context,
                "Doge added",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_detailFragment_to_dogListFragment)
        } else {
            Toast.makeText(
                context,
                "It seems like a field is empty, would you mind completing it?",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun cancelDog() {
        findNavController().navigate(R.id.action_detailFragment_to_dogListFragment)
    }
}
