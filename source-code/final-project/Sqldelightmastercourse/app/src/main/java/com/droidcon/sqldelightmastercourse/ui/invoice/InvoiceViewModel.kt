package com.droidcon.sqldelightmastercourse.ui.invoice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems
import com.droidcon.sqldelightmastercourse.domain.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
        invoiceRepository.getInvoices()
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(invoiceList = result)
                }
            }
            .catch { exception ->
                mutableState.update {
                    InvoiceListState(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun setInvoiceId(invoiceId: Long) {
        mutableState.update { prevState ->
            prevState.copy(newInvoiceId = invoiceId)
        }
    }

    fun getInvoiceItemList(invoiceId: Long) {
        invoiceRepository.getInvoiceItems(invoiceId = invoiceId)
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(invoiceItemList = result)
                }
            }
            .catch { exception ->
                mutableState.update {
                    InvoiceListState(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun addNewInvoiceItem(description: String, qty: Double, price: Double, invoiceId: Long) =
        viewModelScope.launch {
            invoiceRepository.addInvoiceItem(desc = description, qty, price, invoiceId)
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