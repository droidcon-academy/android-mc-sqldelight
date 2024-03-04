package com.droidcon.sqldelightmastercourse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme
import com.droidcon.sqldelightmastercourse.navigation.TinyInvoiceNavHost
import com.droidcon.sqldelightmastercourse.navigation.navigationItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SqldelightMasterCourseTheme {

                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentScreenRoute = backStackEntry.value?.destination?.route
                val bottomNavVisible = navigationItems.any {
                    it.route == currentScreenRoute
                }

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            visible = bottomNavVisible,
                            enter = slideInVertically { it },
                            exit = slideOutVertically { it },
                        ) {
                            NavigationBar(
                                items = navigationItems,
                                currentScreenRoute = currentScreenRoute
                            ) {
                                navController.navigate(it.route)
                            }
                        }
                    }
                ) { paddingValues ->
                    TinyInvoiceNavHost(
                        navController = navController,
                        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                    )
                }
            }
        }
    }
}