package com.example.mycity

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.mycity.ui.MyCityViewModel
import com.example.mycity.ui.screens.CategoriesScreen
import com.example.mycity.ui.screens.DetailScreen
import com.example.mycity.ui.screens.PlacesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    contentType: MyCityContentType,
    viewModel: MyCityViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(when {
                        currentRoute == "categories" -> "My City"
                        currentRoute?.startsWith("places") == true -> uiState.selectedCategory?.let { "Places" } ?: "Places"
                        else -> "Details"
                    })
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Text("←")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "categories",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("categories") {
                CategoriesScreen(
                    uiState = uiState,
                    onCategoryClick = { categoryId ->
                        viewModel.selectCategory(categoryId)
                        navController.navigate("places")
                    }
                )
            }
            composable("places") {
                PlacesScreen(
                    uiState = uiState,
                    onPlaceClick = { placeId ->
                        viewModel.selectPlace(placeId)
                        if (contentType == MyCityContentType.LIST_AND_DETAIL) {
                        } else {
                            navController.navigate("detail")
                        }
                    }
                )
            }
            composable("detail") {
                DetailScreen(uiState = uiState)
            }
        }
    }
}