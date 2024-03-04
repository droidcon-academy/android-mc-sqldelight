package com.droidcon.sqldelightmastercourse.ui

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.droidcon.sqldelightmastercourse.designsystem.component.BottomNavigationIcon
import com.droidcon.sqldelightmastercourse.navigation.BottomNavItem

@Composable
fun NavigationBar(
    items: List<BottomNavItem>,
    currentScreenRoute: String?,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    NavigationBar(
        modifier = modifier,
    ) {
        items.forEach { item ->
            val selected = item.route == currentScreenRoute
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    BottomNavigationIcon(
                        name = item.name,
                        icon = item.icon,
                        selected = selected,
                    )
                }
            )
        }
    }
}