package com.example.mycity.data

import com.example.mycity.R

object LocalDataSource {
    val categories = listOf(
        Category(1, R.string.category_restaurants, R.drawable.ic_restaurant),
        Category(2, R.string.category_parks, R.drawable.ic_park),
        Category(3, R.string.category_coffee, R.drawable.ic_coffee)
    )

    val places = listOf(
        Place(1, 1, R.string.place_rest_1, R.string.desc_rest_1, R.drawable.img_rest_1),
        Place(2, 1, R.string.place_rest_2, R.string.desc_rest_2, R.drawable.img_rest_2),
        Place(3, 2, R.string.place_park_1, R.string.desc_park_1, R.drawable.img_park_1),
        Place(4, 2, R.string.place_park_2, R.string.desc_park_2, R.drawable.img_park_2),
        Place(5, 3, R.string.place_coffee_1, R.string.desc_coffee_1, R.drawable.img_coffee_1)
    )

    fun getPlacesForCategory(categoryId: Int): List<Place> {
        return places.filter { it.categoryId == categoryId }
    }

    fun getPlaceById(placeId: Int): Place? {
        return places.find { it.id == placeId }
    }
}