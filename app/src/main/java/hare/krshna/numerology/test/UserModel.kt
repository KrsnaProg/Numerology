package hare.krshna.numerology.test

import android.util.Log

data class UserModel(
    val firstName: String,
    val lastName: String
){
    init {
        Log.d("Luka", "User model created")
    }
}