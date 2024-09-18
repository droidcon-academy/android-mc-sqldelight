package com.droidcon.tinyinvoice.ui.tax

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
import androidx.compose.runtime.mutableLongStateOf
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
fun AddTaxRoute(
    viewModel: TaxViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val activity = context as? Activity
    AddTaxScreen(
        addNewTax = { description, value ->
            viewModel.addNewTax(description, value)
            activity?.onBackPressed()
        }
    )
}

@Composable
fun AddTaxScreen(
    addNewTax: (description: String, value: Long) -> Unit
) {

    var description by rememberSaveable { mutableStateOf("") }
    var value by rememberSaveable { mutableLongStateOf(0) }
    val isContinued by rememberSaveable(description, value) {
        mutableStateOf(description.isNotEmpty())
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Add new Tax",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(56.dp))
        TextInput(
            label = "description",
            value = description,
            onValueChange = { description = it },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(
            label = "value",
            value = value.toString(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { value = it.toLong() },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.width(160.dp),
            onClick = {
                if (isContinued)
                    addNewTax(description, value)
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
private fun AddTaxScreenPrev() {
    TinyInvoiceTheme {
        Surface {
            AddTaxScreen(
                addNewTax = { _, _ -> }
            )
        }
    }
}