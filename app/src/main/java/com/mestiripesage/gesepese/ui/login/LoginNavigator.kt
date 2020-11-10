package com.mestiripesage.gesepese.ui.login

interface LoginNavigator {
    fun login (email:String,password:String)
    fun forgret()
    fun navigateToRegister()
    fun navigateToHome()
    fun navigateToForget()


}