package com.droidcon.tinyinvoice.ui.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Customer
import com.droidcon.tinyinvoice.domain.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val customerRepository: CustomerRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(CustomerListState())
    val state: StateFlow<CustomerListState> = mutableState.asStateFlow()

    fun getCustomerList() {
        // TODO
    }

    fun addNewCustomer(name: String, address: String, phone: String, email: String) =
        viewModelScope.launch {
            // TODO
        }

}

data class CustomerListState(
    val customerList: List<Customer> = listOf(),
    val errorMessage: String? = null,
)