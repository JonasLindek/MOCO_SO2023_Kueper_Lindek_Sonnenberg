package com.datojo.socialpet.View.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.datojo.socialpet.Background
import com.datojo.socialpet.ViewModel.PetStatus
import com.datojo.socialpet.R
import com.datojo.socialpet.View.overlays.MenuOverlay
import com.datojo.socialpet.View.overlays.TextButton
import com.datojo.socialpet.View.theme.SocialPetTheme
import com.datojo.socialpet.ViewModel.Inventory

@Composable
fun ArcadeScreen(friendListNav: () -> Unit, homeNav: () -> Unit, mallNav: () -> Unit, stats: PetStatus, inventory: Inventory) {
    SocialPetTheme {
        Background(
            R.drawable.arcade, "Arcade",
            Modifier
                .scale(3.5f)
                .fillMaxSize()
                .padding(0.dp, 275.dp)
        )
        MenuOverlay(
            listOf(friendListNav, homeNav, mallNav),
            listOf("Friends", "Home", "Mall"),
            stats
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp, 23.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray.copy(alpha = .8f))
                    .padding(8.dp, 0.dp)
            ) {
                Text(
                    text = inventory.currency.value.toString()
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = {inventory.addCurrency(1)}, name= "Play")
        }
    }
}