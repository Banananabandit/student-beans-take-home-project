package com.example.sbtechincaltest

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sbtechincaltest.ui.theme.StudentBeansAppTheme

@Composable
fun OffersScreen(onItemClick: (id: Int) -> Unit = {}) {
    val viewModel: OffersViewModel = viewModel()
    val state = viewModel.state.value

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 8.dp)) {
            items(state.offers) { offer ->
                OfferItem(
                    offer,
                    onFavoriteClick =  { id, oldValue -> viewModel.toggleFavorite(id, oldValue) },
                    onItemClick = { id -> onItemClick(id) }
                )
            }
        }
        if (state.isLoading)
            CircularProgressIndicator()
        if (state.error != null)
            Text(state.error)
    }
}

@Composable
fun OfferItem(item: CompanyOffer,
              onFavoriteClick: (id: Int, oldValue: Boolean) -> Unit,
              onItemClick: (id: Int) -> Unit
) {
    val icon = if (item.isFavorite)
        Icons.Filled.Favorite
    else
        Icons.Filled.FavoriteBorder

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(item.id) }
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)) {
            CompanyIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15f))
            CompanyOfferDetails(
                Modifier.weight(0.7f),
                item.description)
            CompanyIcon(icon, Modifier.weight(0.15f)) {
                onFavoriteClick(item.id, item.isFavorite)
            }
        }
    }
}

@Composable
fun CompanyIcon(icon: ImageVector, modifier: Modifier, onClick: () -> Unit = {}) { // Unit = {} is a default empty function unless provided the actual function
    Image(imageVector = icon,
        contentDescription = "Restaurant icon",
        modifier = modifier
            .padding(8.dp)
            .clickable(indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                }) { onClick() }
    )
}

@Composable
fun CompanyOfferDetails(
    modifier: Modifier,
    description: String,
    horizontal: Alignment.Horizontal = Alignment.Start
    ) {
    Text(text = description,
        style = MaterialTheme.typography.body2,
        modifier = modifier.padding(8.dp)
        )
}

@Preview
@Composable
fun DefaultPreviewOne() {
    StudentBeansAppTheme {
        OffersScreen()
    }
}