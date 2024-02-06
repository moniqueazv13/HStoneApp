package com.example.hstoneapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hstoneapp.domain.InfoHelper
import com.example.hstoneapp.presentation.UiState
import com.example.hstoneapp.presentation.ui.components.CustomHorizontalCard
import com.example.hstoneapp.presentation.ui.components.randomColor
import com.example.hstoneapp.presentation.ui.theme.HStoneAppTheme
import com.example.hstoneapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HStoneAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.cultured)
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    viewModel.getInfo()

    val state = viewModel.uiState.collectAsState()

    when (state.value) {
        is UiState.Success -> {

            val info = (state.value as UiState.Success).value

            info.classes?.let {

                viewModel.setInfoResult(info)

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Box(
                        contentAlignment = Alignment.TopStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 90.dp, start = 24.dp)
                    ) {
                        Column {
                            CustomMainHeader()
                            CustomFiltersList(viewModel)
                        }
                    }
                }
            }
        }

        is UiState.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.placeholder_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun CustomFiltersList(viewModel: MainViewModel) {
    Box {
        val context = LocalContext.current
        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
            verticalArrangement = Arrangement.SpaceEvenly,
            content = {

                viewModel.getCardInfoList().forEach { (key, values) ->
                    item {
                        Text(
                            modifier = Modifier
                                .padding(
                                    top = 24.dp
                                ),
                            color = Color(R.color.dark_silver),
                            fontSize = 16.sp,
                            text = key,
                            fontFamily = FontFamily(Font(R.font.avenir_400))
                        )
                    }

                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            content = {
                                item {
                                    values.map {
                                        CustomItemFilterCard(it, context, key)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        )
    }
}

@Composable
private fun CustomItemFilterCard(
    it: String,
    context: Context,
    key: String
) {
    CustomHorizontalCard(
        text = it,
        font = FontFamily(Font(R.font.avenir_400)),
        modifierText = Modifier.padding(
            4.dp
        ),
        colorCard = randomColor(),
        colorText = colorResource(id = R.color.white),
        fontSizeText = 18.sp,
        textAlign = TextAlign.Left,
        shapeSize = RoundedCornerShape(
            16.dp
        ),
        modifierColumn = Modifier.padding(
            top = 50.dp,
            start = 10.dp
        ),
        modifierCard = Modifier
            .padding(
                start = 16.dp,
                top = 10.dp
            )
            .width(144.dp)
            .height(104.dp)
            .clickable {
                goToDetailsActivity(
                    context,
                    it,
                    key
                )
            }
    )
}

@Composable
private fun CustomMainHeader() {
    Text(
        text = stringResource(id = R.string.title_home),
        color = colorResource(id = R.color.dark_gunmetal),
        fontSize = 40.sp,
        modifier = Modifier.padding(bottom = 8.dp),
        fontFamily = FontFamily(Font(R.font.avenir_900))
    )
    Divider(modifier = Modifier.padding(8.dp), thickness = 1.dp, color = Color.White)
}

private fun intent(mContext: Context, intentClass: Class<*>) {
    mContext.startActivity(Intent(mContext, intentClass))
}

private fun goToDetailsActivity(
    context: Context,
    value: String,
    key: String
) {
    intent(
        mContext = context,
        intentClass = DetailsActivity::class.java
    )
    InfoHelper.setItemClicked(value)
    InfoHelper.setItemKeyClicked(key)
}