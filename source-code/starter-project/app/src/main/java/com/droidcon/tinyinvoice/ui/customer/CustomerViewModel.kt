package com.droidcon.tinyinvoice.ui.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Customer
import com.droidcon.tinyinvoice.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CustomerViewModel(
    private val customerRepository: CustomerRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(CustomerListState())
    val state: StateFlow<CustomerListState> = mutableState.asStateFlow()

    fun getCustomerList() {
        customerRepository.getCustomers()
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(customerList = result)
                }
            }
            .catch { exception ->
                mutableState.update {
                    CustomerListState(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun addNewCustomer(name: String, address: String, phone: String, email: String) =
        viewModelScope.launch {
            customerRepository.addUpdateCustomer(name, address, phone, email)
        }

}

data class CustomerListState(
    val customerList: List<Customer> = listOf(),
    val errorMessage: String? = null,
)