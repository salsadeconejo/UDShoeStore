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

        //This triggers when the user tries to save the new dog. This calls saveDog function
        // and decides an action based on the boolean returned.
        //My issue is as follows:
        //1. Fill all the fields in DetailFragment
        //2. Hit save
        //3. The screen transitions to the DogListFragment, a toast message showing:
        // "Doge added"
        //4. Shortly after, the toast error message for adding a dog shows:
        // "It seems like a field is empty, would you mind completing it?"
        // It seems to me that the addDogResults object is being called twice, once true and then once false
        // There is no reason for this, could you help me?
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
