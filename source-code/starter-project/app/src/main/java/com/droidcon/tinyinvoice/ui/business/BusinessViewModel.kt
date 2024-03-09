package com.droidcon.tinyinvoice.ui.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.tinyinvoice.domain.model.Business
import com.droidcon.tinyinvoice.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BusinessViewModel(
    private val businessRepository: BusinessRepository,
) : ViewModel() {

    private val mutableState = MutableStateFlow(BusinessListState())
    val state: StateFlow<BusinessListState> = mutableState.asStateFlow()

    fun getBusinessList() {
        businessRepository.getBusinesses()
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(businessList = result)
                }
            }
            .catch { exception ->
                mutableState.update {
                    BusinessListState(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun addNewBusiness(name: String, address: String, phone: String, email: String) =
        viewModelScope.launch {
            businessRepository.addUpdateBusiness(name, address, phone, email)
        }

}

data class BusinessListState(
    val businessList: List<Business> = listOf(),
    val errorMessage: String? = null,
)