package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Product {
    @SerializedName("orders")
    @Expose
    private var orders: List<Any?>? = null

    @SerializedName("_id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("quantity")
    @Expose
    private var quantity: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("price")
    @Expose
    private var price: String? = null

    @SerializedName("__v")
    @Expose
    private var v: Int? = null

    fun getOrders(): List<Any?>? {
        return orders
    }

    fun setOrders(orders: List<Any?>?) {
        this.orders = orders
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getQuantity(): String? {
        return quantity
    }

    fun setQuantity(quantity: String?) {
        this.quantity = quantity
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getPrice(): String? {
        return price
    }

    fun setPrice(price: String?) {
        this.price = price
    }

    fun getV(): Int? {
        return v
    }

    fun setV(v: Int?) {
        this.v = v
    }

}