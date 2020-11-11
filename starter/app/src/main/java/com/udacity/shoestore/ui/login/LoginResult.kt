package com.udacity.shoestore.ui.login

/**
 * Authentication result : success (user details) or error message.
 * This piece of code was made with the Android helper
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)