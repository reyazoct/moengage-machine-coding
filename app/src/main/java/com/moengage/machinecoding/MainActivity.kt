package com.moengage.machinecoding

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moengage.machinecoding.ui.screens.question.QuestionScreen
import com.moengage.machinecoding.ui.screens.question.QuestionVM
import com.moengage.machinecoding.ui.screens.start.StartScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
private fun Navigation() {
    val navController = rememberNavController()
    val questionVM = viewModel<QuestionVM>()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "startScreen"
    ) {
        composable(
            route = "startScreen",
        ) {
            StartScreen {
                navController.navigate("questionScreen")
            }
        }

        composable(
            route = "questionScreen",
        ) {
            QuestionScreen(questionVM)
        }
    }
}

