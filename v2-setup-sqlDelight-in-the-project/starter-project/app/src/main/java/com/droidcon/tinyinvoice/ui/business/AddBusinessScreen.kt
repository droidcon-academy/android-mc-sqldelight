package com.droidcon.tinyinvoice.ui.business

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droidcon.tinyinvoice.designsystem.component.TextInput
import com.droidcon.tinyinvoice.designsystem.preview.ThemePreviews
import com.droidcon.tinyinvoice.designsystem.theme.TinyInvoiceTheme

@Composable
fun AddBusinessRoute(
    viewModel: BusinessViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val activity = context as? Activity
    AddBusinessScreen(
        addNewBusiness = { name, address, phone, email ->
            viewModel.addNewBusiness(name, address, phone, email)
            activity?.onBackPressed()
        }
    )
}

@Composable
fun AddBusinessScreen(
    addNewBusiness: (name: String, address: String, phone: String, email: String) -> Unit
) {

    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    val isContinued by rememberSaveable(name, address, phone, email) {
        mutableStateOf(name.isNotEmpty() && address.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty())
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Add new Business",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(56.dp))
        TextInput(
            label = "name",
            value = name,
            onValueChange = { name = it },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(
            label = "address",
            value = address,
            minLines = 4,
            onValueChange = { address = it },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(
            label = "phone",
            value = phone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { phone = it },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(
            label = "email",
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email = it },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.width(160.dp),
            onClick = {
                if (isContinued)
                    addNewBusiness(name, address, phone, email)
                else
                    Toast.makeText(context, "Please fill add field", Toast.LENGTH_LONG).show()
            },
        ) {
            Text(text = "Add")
        }
    }
}

@ThemePreviews
@Composable
private fun AddBusinessScreenPrev() {
    TinyInvoiceTheme {
        Surface {
            AddBusinessScreen(
                addNewBusiness = { _, _, _, _ -> }
            )
        }
    }
}