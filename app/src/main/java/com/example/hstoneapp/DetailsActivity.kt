package com.example.hstoneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.hstoneapp.domain.InfoHelper
import com.example.hstoneapp.domain.model.CardByFilterEntity
import com.example.hstoneapp.presentation.UiState
import com.example.hstoneapp.presentation.ui.components.CustomFabButton
import com.example.hstoneapp.presentation.ui.components.CustomVerticalCard
import com.example.hstoneapp.presentation.ui.theme.HStoneAppTheme
import com.example.hstoneapp.presentation.viewmodel.DetailsViewModel
import org.koin.androidx.compose.get

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HStoneAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailsScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailsScreen(viewModel: DetailsViewModel = get()) {
        viewModel.setItemName(
            filterName = InfoHelper.getInstance().itemKeySelected,
            itemName = InfoHelper.getInstance().itemSelected
        )

        val state = viewModel.uiState.collectAsState()

        when (state.value) {
            is UiState.Success -> {
                val cardListRaceResult = (state.value as UiState.Success).value

                if (cardListRaceResult.isNotEmpty()) {
                    Column {
                        CustomDetailsHeader(InfoHelper.getInstance().itemKeySelected)
                        CustomLazyVerticalGrid(cardListRaceResult)
                    }
                } else {
                    CustomDetailsHeader(stringResource(id = R.string.placeholder_text))
                }
            }

            is UiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.Center)
                        .padding(top = 90.dp)
                )
            }

            is UiState.Error -> {
                CustomDetailsHeader(stringResource(id = R.string.placeholder_text))
            }
        }
    }

    @Composable
    private fun CustomLazyVerticalGrid(cardListRaceResult: List<CardByFilterEntity>) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            cardListRaceResult.map {
                item {
                    CustomVerticalCard(
                        Modifier
                            .height(224.dp)
                            .width(189.dp)
                            .padding(8.dp),
                        rememberAsyncImagePainter(it.img?: getDrawable(R.drawable.placeholder_card)),
                        stringResource(id = R.string.accessibility_item_image)
                    )
                }
            }
        }
    }

    @Composable
    private fun CustomDetailsHeader(headerText: String) {
        Box(
            modifier = Modifier
                .padding(top = 90.dp, start = 24.dp, end = 24.dp),
            contentAlignment = Alignment.TopStart,
        ) {

            CustomFabButton(
                contextRef = this@DetailsActivity,
                modifierFab = Modifier
                    .size(80.dp),
                backgroundFabColor = colorResource(id = R.color.dark_gunmetal),
                modifierImage = Modifier.size(45.dp),
                painterImage = painterResource(id = R.drawable.ic_button_back),
                contentDescriptionImage = stringResource(id = R.string.accessibility_fab)
            )

            Text(
                text = headerText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 24.dp),
                textAlign = TextAlign.End,
                fontFamily = FontFamily(Font(R.font.avenir_400)),
                color = colorResource(id = R.color.dark_gunmetal),
                fontSize = 22.sp,
            )
        }
    }
}
