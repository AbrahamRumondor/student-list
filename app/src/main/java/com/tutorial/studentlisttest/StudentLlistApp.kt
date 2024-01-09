package com.tutorial.studentlisttest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tutorial.studentlisttest.view.LoginScreen
import com.tutorial.studentlisttest.view.StudentListScreen

@Composable
fun StudentListApp(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navigateToStudents = {
                navController.navigate(Screen.StudentListScreen.route)
            })
        }
        composable(route = Screen.StudentListScreen.route){
            StudentListScreen()
        }
    }
}