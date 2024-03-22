package com.droidcon.tinyinvoice.ui.tax

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Tax
import com.droidcon.tinyinvoice.domain.repository.TaxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaxViewModel @Inject constructor(
    private val taxRepository: TaxRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(TaxListState())
    val state: StateFlow<TaxListState> = mutableState.asStateFlow()

    fun getTaxList() {
        // TODO
    }

    fun addNewTax(description: String, value: Long) = viewModelScope.launch {
        // TODO
    }

}

data class TaxListState(
    val taxList: List<Tax> = listOf(),
    val errorMessage: String? = null,
)