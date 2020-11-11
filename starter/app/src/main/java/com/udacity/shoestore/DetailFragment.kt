package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Dog

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
        binding.newDog = Dog()
        binding.newDog?.images?.add(R.drawable.d11)
        setButtonListeners(binding)
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setButtonListeners(binding: FragmentDetailBinding) {
        binding.apply {
            cancelButton.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_dogListFragment)
            }
            saveButton.setOnClickListener {

                binding.newDog?.apply {
                    if (name.isBlank() ||
                        description.isBlank() ||
                        company.isBlank()
                    ) {
                        Toast.makeText(
                            context,
                            "It seems like a field is empty, would you mind completing it?",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        dogViewModel.addDog(this)
                        findNavController().navigate(R.id.action_detailFragment_to_dogListFragment)
                    }
                }
            }
        }
    }

}
