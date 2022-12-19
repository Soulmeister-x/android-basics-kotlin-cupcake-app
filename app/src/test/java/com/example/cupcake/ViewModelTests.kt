package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Date

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        // create instance of OrderViewModel
        val vm = OrderViewModel()

        // set observer and start action
        vm.quantity.observeForever {}
        vm.setQuantity(12)

        // check if set value is correct
        assertEquals(12, vm.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val vm = OrderViewModel()
        vm.price.observeForever {}
        vm.setQuantity(12)
        val expectValue = NumberFormat.getCurrencyInstance().format(27.00)
        assertEquals(expectValue.toString(), vm.price.value)
    }

    @Test
    fun price_six_cupcakes_no_sameday_pickup() {
        val vm = OrderViewModel()
        vm.price.observeForever {}
        vm.setQuantity(6)
        vm.setDate(vm.dateOptions[1])
        val expectValue = NumberFormat.getCurrencyInstance().format(12.00)

        assertEquals(expectValue, vm.price.value)
    }



}