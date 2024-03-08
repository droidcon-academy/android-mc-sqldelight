package com.droidcon.tinyinvoice.ui.tax

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Tax
import com.droidcon.tinyinvoice.domain.repository.TaxRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaxViewModel(
    private val taxRepository: TaxRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(TaxListState())
    val state: StateFlow<TaxListState> = mutableState.asStateFlow()

    fun getTaxList() {
        taxRepository.getTaxes()
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(taxList = result)
                }
            }
            .catch { exception ->
                mutableState.update {
                    TaxListState(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun addNewTax(description: String, value: Long) = viewModelScope.launch {
        taxRepository.addUpdateTax(desc = description, value = value)
    }

}

data class TaxListState(
    val taxList: List<Tax> = listOf(),
    val errorMessage: String? = null,
)