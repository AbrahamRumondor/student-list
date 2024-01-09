package com.tutorial.studentlisttest

sealed class Screen(val route:String) {
    object LoginScreen:Screen("loginscreen")
    object StudentListScreen:Screen("studentlistscreen")
}