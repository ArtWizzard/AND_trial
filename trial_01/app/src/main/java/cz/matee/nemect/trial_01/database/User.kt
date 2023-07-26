package cz.matee.nemect.trial_01.database

import cz.matee.nemect.trial_01.R

data class User(
    val id: Int = 1,
    val name: String = "Temp user",
    val profilePicture: Int = R.mipmap.tmp_profile_foreground
)
