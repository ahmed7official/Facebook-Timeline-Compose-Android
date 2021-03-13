package com.android.compose01.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.compose01.R
import com.android.compose01.ui.theme.iconsBackground
import com.android.compose01.ui.theme.purple500


@Composable
fun Header() {

    TopAppBar(
        backgroundColor = Color.White,
        title = {

            Icon(
                painter = painterResource(id = R.drawable.facebook_header),
                contentDescription = null,
                tint = purple500,
            )

        },

        actions = {

            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(iconsBackground)

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_round_search_24),
                    contentDescription = "",
                    tint = Color.Black,
                )
            }

            Spacer(modifier = Modifier.padding(start = 8.dp))

            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(iconsBackground)

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_messenger),
                    contentDescription = "",
                    tint = Color.Black,
                )
            }

            Spacer(modifier = Modifier.padding(start = 8.dp))

        },
    )


    TabsLayout()

}


@Composable
fun TabsLayout() {

    val selectedTabIndex = remember { mutableStateOf(0) }



    val indicator = @Composable { tabPositions: List<TabPosition> ->
        TabRowDefaults.Indicator(
            color = colorResource(R.color.purple_500),
            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value])
        )
    }

    TabRow(
        selectedTabIndex = selectedTabIndex.value,
        indicator = indicator,
        backgroundColor = Color.White
    ) {



        Tab(
            selected = false,
            onClick = { selectedTabIndex.value = 0 },
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_round_home_24),
                contentDescription = "",
                modifier = Modifier.padding(16.dp),
                tint = if (selectedTabIndex.value == 0) purple500 else Color.Gray,
            )
        }


        Tab(selected = false, onClick = { selectedTabIndex.value = 1 }) {
            Icon(
                painter = painterResource(R.drawable.ic_round_storefront_24),
                contentDescription = "",
                modifier = Modifier.padding(16.dp),
                tint = if (selectedTabIndex.value == 1) purple500 else Color.Gray,
            )
        }

        Tab(selected = false, onClick = { selectedTabIndex.value = 2 }) {
            Icon(
                painter = painterResource(R.drawable.ic_round_notifications_24),
                contentDescription = "",
                modifier = Modifier.padding(16.dp),
                tint = if (selectedTabIndex.value == 2) purple500 else Color.Gray,
            )
        }

        Tab(selected = false, onClick = { selectedTabIndex.value = 3 }) {
            Icon(
                painter = painterResource(R.drawable.ic_round_menu_24), contentDescription = "",
                modifier = Modifier.padding(16.dp),
                tint = if (selectedTabIndex.value == 3) purple500 else Color.Gray,
            )
        }

    }

}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
