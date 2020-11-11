package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Dog

class DogViewModel : ViewModel() {
    val dogList = staticDogs()
    fun refreshDogs() {
        dogListLivedata.value = dogList
    }

    val dogListLivedata: MutableLiveData<List<Dog>> = MutableLiveData()

    fun addDog(dog: Dog) {
        dogList.add(dog)
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
