package com.droidcon.tinyinvoice.ui.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Business
import com.droidcon.tinyinvoice.domain.repository.BusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(
    private val businessRepository: BusinessRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(BusinessListState())
    val state: StateFlow<BusinessListState> = mutableState.asStateFlow()

    fun getBusinessList() {
        // TODO
    }

    fun addNewBusiness(name: String, address: String, phone: String, email: String) =
        viewModelScope.launch {
            // TODO
        }

}

data class BusinessListState(
    val businessList: List<Business> = listOf(),
    val errorMessage: String? = null,
)