package com.mestiripesage.gesepese.data.remote

class ApiGesepese {

    companion object{
        const val Base_URL ="http://192.168.1.183:3000"
        // User
        const val LOGIN_USER = "/users/login"
        const val REGISTER_USER ="/users/register"
        const val REMOVE_USER ="/users/remove/{id}"
        const val UPDATE_USER ="/users/update"
        // Product
        const val ADD_PRODUCT = "/products/add"
        const val ALL_PRODUCT ="/products/all"
        const val REMOVE_PRODUCT ="/products/remove/{id}"
        const val UPDATE_PRODUCT ="/products/update"
        // Camion
        const val ADD_CAMION = "/camions/add"
        const val ALL_CAMION ="/camions/all"
        const val REMOVE_CAMION ="/camions/remove/{id}"
        const val UPDATE_CAMION ="/camions/update"
        // Customers
        const val ADD_CUSTOMER = "/customers/add"
        const val ALL_CUSTOMER ="/customers/all"
        const val REMOVE_CUSTOMER ="/customers/remove/{id}"
        const val UPDATE_CUSTOMER ="/customers/update"
        // Reciept
        const val ADD_RECIEPT = "/reciepts/add"
        const val ALL_RECIEPT="/reciepts/all"
        const val REMOVE_RECIEPT ="/reciept/remove/{id}"
        const val UPDATE_RECIEPT ="/reciept/update"
    }
}