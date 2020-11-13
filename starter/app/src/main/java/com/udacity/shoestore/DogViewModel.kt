package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Dog

class DogViewModel : ViewModel() {
    private val dogList = staticDogs()
    private val _dogListLiveData: MutableLiveData<List<Dog>> = MutableLiveData()
    val dogListLiveData: LiveData<List<Dog>>
        get() = _dogListLiveData
    var newDog: Dog = createNewDog()

    fun refreshDogs() {
        _dogListLiveData.value = dogList
    }

    fun addDog(): Boolean {
        newDog.let {
            if (!it.company.isBlank() &&
                !it.description.isBlank() &&
                !it.name.isBlank()
            ) {
                dogList.add(it)
                return true
            }
        }
        return false
    }

    fun resetNewDog() {
        newDog = createNewDog()
    }

    private fun createNewDog(): Dog {
        return Dog().apply {
            images.add(R.drawable.d5)
        }
    }

    companion object {
        private fun staticDogs(): MutableList<Dog> {
            val listOfDogs: MutableList<Dog> = mutableListOf()
            val d1 = Dog(
                "Classic Doge",
                10.0,
                "Doge Inc.",
                "Classic, old ancient Doge",
                mutableListOf(R.drawable.d1)
            )

            val d2 = Dog(
                "Joker Doge",
                -12.0,
                "Batman Inc.",
                "Are you serious? Why?",
                mutableListOf(R.drawable.d4)
            )

            val d3 = Dog(
                "Sentimental Doge",
                8.0,
                "Chemical Romance Inc.",
                "You can feel the bark in your skin",
                mutableListOf(R.drawable.d9)
            )

            val d4 = Dog(
                "Astral Doge",
                9999.0,
                "God Inc.",
                "L̶̢͎̠̺̳͚̬̱̲̘̓̈́̾̉͂ẽ̴͍̮̪̠̺̰̲́̕t̸̡̨̡̤̝̝̭͎̟̪̜͜͜͝ͅ ̸̯̩̜̤̥̫̟͗̓̊͊̏̋̔̃̓t̶̛̻͕̞̐́̈́̏̕̕͝ḩ̶̧̫̩͎͎̺̯̖͍͖̝͂̈̃͛̂͆̓́̅͜é̸̠͎̞̦̬͕͚̩̳̳̳̗̏̏̎͝ͅ ̵̡̼̲̤̰̣͕̺̀̉͋͌̒̌̈́̇̒͜ḑ̸̻̱̣̭͈̝̙̹̗͎̟̚ơ̷̧̨͔͍͙͔̦̤̄͛͗͂̿́̉̓̒͒̇̕̚͝g̵̦̍̌̊̅̋͛͑̐̏̌͝͝ę̴̼͚̟̫͖̘̮̈́̿̈́͂̅͗̾̉͋̑̚͘ ̶̢̢̱̳̖̙̹̮͒̀̃̍̍ì̸̡͙͈̞̯̞͉̙͚̄̋̍̐̎̾͂̐̅ņ̴̢̻̹̬̝̟̯̜͈́̏̈͜",
                mutableListOf(R.drawable.d6)
            )

            val d5 = Dog(
                "Subversive Doge",
                2.0,
                "Meta Inc.",
                "Ahoy from down here, my friend",
                mutableListOf(R.drawable.d10)
            )
            listOfDogs.addAll(listOf(d1, d2, d3, d4, d5))
            return listOfDogs
        }
    }
}
