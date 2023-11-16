
package com.zarplaty.daet.payday.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.financialtracker.app.presentation.MainEvent
import com.zarplaty.daet.payday.R
import com.zarplaty.daet.payday.data.VALUE_ONE
import com.zarplaty.daet.payday.domain.model.ElementOffer
import com.zarplaty.daet.payday.domain.model.StatusApplication
import com.zarplaty.daet.payday.domain.model.basedto.BaseState
import com.zarplaty.daet.payday.domain.model.basedto.CardsDebit
import com.zarplaty.daet.payday.theme.titleText
import com.zarplaty.daet.payday.theme.white

@Composable
fun ItemDebitCard(
    modifier: Modifier = Modifier,
    card: CardsDebit,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            //.border(width = 3.dp, color = grey, shape = RoundedCornerShape(15.dp))
            .clip(shape = RoundedCornerShape(25.dp))
            .background(color = white)
            .padding(16.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(
                        MainEvent.OnChangeStatusApplication(
                            StatusApplication.Offer(
                                currentBaseState = baseState,
                                ElementOffer(
                                    nameButton = card.orderButtonText,
                                    name = card.name,
                                    pathImage = card.screen,
                                    rang = card.score,
                                    description = card.description,
                                    amount = card.summPrefix + " " + card.summMin + " " + card.summMid + " " + card.summMax + " " + card.summPostfix,
                                    bet = card.percentPrefix + " " + card.percent + " " + card.percentPostfix,
                                    term = card.termPrefix + " " + card.termMin + " " + card.termMid + " " + card.termMax + " " + card.termPostfix,
                                    showMir = card.showMir,
                                    showVisa = card.showVisa,
                                    showMaster = card.showMastercard,
                                    showQiwi = card.showQiwi,
                                    showYandex = card.showYandex,
                                    showCache = card.showCash,
                                    showPercent = card.hidePercentFields,
                                    showTerm = card.hideTermFields,
                                    order = card.order
                                )
                            )
                        )
                    )
                },
            model = card.screen,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(13.dp))
        Text(
            color = titleText,
            fontStyle = FontStyle(R.font.nunito),
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            text = card.name
        )
        /*Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = white,
                fontStyle = FontStyle(R.font.open_sans),
                fontSize = 19.sp,
                fontWeight = FontWeight(700),
                text = card.name
            )
            Rang(
                rang = card.score
            )
        }*/
        Spacer(modifier = modifier.height(13.dp))
        RowData(
            title = stringResource(id = R.string.amount),
            content = card.summPrefix +" " + card.summMin +" " + card.summMid +" " + card.summMax +" " + card.summPostfix
        )
        if (card.hidePercentFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.bet),
                content = card.percentPrefix +" " + card.percent +" " + card.percentPostfix
            )
        }
        if (card.hideTermFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.term),
                content = card.termPrefix +" "+ card.termMin +" " + card.termMid +" " + card.termMax +" " + card.termPostfix
            )
        }
        Spacer(modifier = modifier.height(13.dp))
        RowCard(
            showVisa = card.showVisa,
            showMaster = card.showMastercard,
            showYandex = card.showYandex,
            showMir = card.showMir,
            showQivi = card.showQiwi,
            showCache = card.showCash
        )
        Spacer(modifier = modifier.height(13.dp))
        RowButtons(
            titleOffer = card.orderButtonText,
            onEvent = onEvent,
            currentBaseState = baseState,
            name = card.name,
            pathImage = card.screen,
            rang = card.score,
            description = card.description,
            amount = card.summPrefix +" " + card.summMin +" " + card.summMid +" " + card.summMax +" " + card.summPostfix,
            bet  = card.percentPrefix +" " + card.percent +" " + card.percentPostfix,
            term = card.termPrefix +" "+ card.termMin +" " + card.termMid +" " + card.termMax +" " + card.termPostfix,
            showMir = card.showMir,
            showVisa = card.showVisa,
            showMaster = card.showMastercard,
            showQiwi = card.showQiwi,
            showYandex = card.showYandex,
            showCache = card.showCash,
            showPercent = card.hidePercentFields,
            showTerm = card.hideTermFields,
            order = card.order
        )
    }
}
