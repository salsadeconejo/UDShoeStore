package com.udacity.shoestore.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 * This piece of code was made with the Android helper
 */
data class LoggedInUser(
    val userId: String,
    val displayName: String
)