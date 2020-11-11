package com.udacity.shoestore.ui.login

/**
 * Data validation state of the login form.
 * This piece of code was made with the Android helper
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)