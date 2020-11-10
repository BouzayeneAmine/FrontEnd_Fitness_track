package com.mestiripesage.gesepese.data.remote

class ApiGesepese {

    companion object{
        const val Base_URL ="http://192.168.1.183:3000"
        const val LOGIN_USER = "/users/login"
        const val REGISTER_USER ="/users/register"
        const val REMOVE_USER ="/users/remove/{id}"
        const val UPDATE_USER ="/users/update"
        // product
        const val ADD_PRODUCT = "/products/add"
        const val ALL_PRODUCT ="/products/all"
        const val REMOVE_PRODUCT ="/products/remove/{id}"
        const val UPDATE_PRODUCT ="/products/update"
    }
}