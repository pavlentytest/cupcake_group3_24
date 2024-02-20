package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val CUPCAKE_PRICE = 100.00
private const val ADD_PRICE = 500.00


class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    val listofdates = genDates()

    fun setQuantity(numberCupcake: Int) {
        _quantity.value = numberCupcake
        priceCalc()
    }

    fun priceCalc() {
        var total = (_quantity.value ?: 0) * CUPCAKE_PRICE
        if(_date.value == listofdates[0]) {
            total += ADD_PRICE
        }
        _price.value = total
    }

    fun setFlavor(flavor: String) {
        _flavor.value = flavor
    }

    fun setDate(date: String) {
        _date.value = date
        priceCalc()
    }

    fun genDates() : List<String> {
        val listdates = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            listdates.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)
        }
        return listdates
    }
}