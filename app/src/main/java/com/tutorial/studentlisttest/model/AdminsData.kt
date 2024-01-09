package com.tutorial.studentlisttest.model

val admins = listOf<User>(
    User("alfagift-admin", "asdf")
)

fun isAdmin(username: String, password: String): Boolean{
    for (user in admins){
        if(user.username == username && user.password == password){
            return true
        }
    }
    return false
}