package com.example.hstoneapp.domain

object InfoHelper {
    var itemSelected: String = "Mage"
        private set

    var itemKeySelected: String = "Classes"
        private set

    fun setItemClicked(itemSelected: String) {
        this.itemSelected = itemSelected
    }

    fun setItemKeyClicked(itemKeySelected: String) {
        this.itemKeySelected = itemKeySelected
    }
}
