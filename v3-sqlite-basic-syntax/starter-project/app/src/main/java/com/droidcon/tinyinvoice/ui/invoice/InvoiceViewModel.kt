package com.droidcon.tinyinvoice.ui.invoice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.InvoiceItem
import com.droidcon.tinyinvoice.domain.model.InvoiceWithItems
import com.droidcon.tinyinvoice.domain.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceViewModel @Inject constructor(
    private val invoiceRepository: InvoiceRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(InvoiceListState())
    val state: StateFlow<InvoiceListState> = mutableState.asStateFlow()

    fun getInvoiceList() {
        // TODO
    }

    fun setInvoiceId(invoiceId: Long) {
        mutableState.update { prevState ->
            prevState.copy(newInvoiceId = invoiceId)
        }
    }

    fun getInvoiceItemList(invoiceId: Long) {
        // TODO
    }

    fun addNewInvoiceItem(description: String, qty: Double, price: Double, invoiceId: Long) =
        viewModelScope.launch {
            // TODO
        }

    suspend fun addNewInvoice(
        businessId: Long,
        customerId: Long,
        taxId: Long,
        isPaid: Boolean = false,
    ): Long {
        invoiceRepository.addInvoice(businessId, customerId, taxId, isPaid)
        return invoiceRepository.lastInsertRowId()
    }

}

data class InvoiceListState(
    val invoiceList: List<InvoiceWithItems> = listOf(),
    val invoiceItemList: List<InvoiceItem> = listOf(),
    val newInvoiceId: Long = -1,
    val errorMessage: String? = null,
)