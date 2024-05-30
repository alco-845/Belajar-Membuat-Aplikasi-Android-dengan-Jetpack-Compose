package com.alcorp.submission.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alcorp.submission.R
import com.alcorp.submission.data.ShipRepository
import com.alcorp.submission.ui.ViewModelFactory

@Composable
fun DetailScreen(
    id: Int,
    viewModel: DetailViewModel = viewModel(factory = ViewModelFactory(ShipRepository())),
    navigateBack: () -> Unit,
) {
    viewModel.getShipById(id).let { ship ->
        DetailContent(
            shipPhoto = ship.shipPhoto,
            name = ship.shipName,
            shipDesc = ship.shipDesc,
            shipClass = ship.shipClass,
            shipCountry = ship.shipCountry,
            onBackClick = navigateBack
        )
    }
}

@Composable
fun DetailContent(
    shipPhoto: Int,
    name: String,
    shipDesc: String,
    shipClass: String,
    shipCountry: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                Image(
                    painter = painterResource(shipPhoto),
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = name,
                    fontSize = 32.sp,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = stringResource(R.string.description),
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                Text(
                    text = shipDesc,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Justify,
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.ship_class),
                        fontWeight = FontWeight.Light,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = shipClass,
                        style = MaterialTheme.typography.body2,
                    )
                }
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.ship_country),
                        fontWeight = FontWeight.Light,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = shipCountry,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        }
    }
}