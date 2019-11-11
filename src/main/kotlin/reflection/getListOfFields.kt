package reflection

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

fun main() {
    getListOfFields()
}

fun getListOfFields() {

//    println(Profile::class.memberProperties)
//    println(Profile::class.declaredMemberProperties)
//    println(Profile::class.members)
//    println(Profile::class.members)

    val profile = Profile(true, false, true, true)
    if (profile.address) {
        profileMap.add(ProfileItem(Profile::address.name, profile.address))
    }
    if(profile.birth) {
        profileMap.add(ProfileItem(Profile::birth.name, profile.birth))
    }
    if(profile.gender) {
        profileMap.add(ProfileItem(Profile::gender.name, profile.gender))
    }
    if(profile.address) {
        profileMap.add(ProfileItem(Profile::address.name, profile.address))
    }
    print(profileMap)
}

val profileMap = arrayListOf<ProfileItem>()

data class ProfileItem(val profile: String, val value: Boolean)


data class Profile(
    val name: Boolean,
    val birth: Boolean,
    val gender: Boolean,
    val address: Boolean
)