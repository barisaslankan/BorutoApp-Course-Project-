package com.barisaslankan.borutoapp.navigation

sealed class Screen(val route : String){
    object Splash : Screen("splash_screen")
    object Welcome : Screen("welcome_screen")
    object Home : Screen("home_screen")
    object Detail : Screen("detail_screen/{heroId}"){
        fun passHeroId(heroID : Int) : String{
            return "detail_screen/$heroID"
        }
    }
    object Search : Screen("search_screen")
}
