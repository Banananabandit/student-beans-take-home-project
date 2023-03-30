package com.example.sbtechincaltest.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.sbtechincaltest.screens.CompanyOfferDetails
import com.example.sbtechincaltest.viewmodels.OfferDetailsViewModel

@Composable
fun OfferDetailsScreen() {
    val viewModel: OfferDetailsViewModel = viewModel()
    val item = viewModel.state.value
    if (item != null) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ) {
            //TODO: FIX the koin image
            AsyncImage(item.imageUrl,
                "imageUrl full size ",
                Modifier.padding(
                    top = 32.dp,
                    bottom = 32.dp
                )
            )
            CompanyOfferDetails(
                Modifier.padding(bottom = 32.dp),
                item.description,
                Alignment.CenterHorizontally
            )
        }
    }
}