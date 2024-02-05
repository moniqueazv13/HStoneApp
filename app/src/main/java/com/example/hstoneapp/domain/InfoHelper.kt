package com.example.hstoneapp.domain

class InfoHelper private constructor() {
    var itemSelected: String = "Mage"
    var itemKeySelected: String = "Classes"

    companion object {
        private var INSTANCE: InfoHelper? = null
        fun getInstance(): InfoHelper {
            if (null == INSTANCE) {
                INSTANCE = InfoHelper()
            }
            return INSTANCE!!
        }
    }

    fun setItemClicked(itemSelected: String) {
        this.itemSelected = itemSelected
    }

    fun setItemKeyClicked(itemKeySelected: String) {
        this.itemKeySelected = itemKeySelected
    }
}