package com.example.mycity.data
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.mycity.R
import com.example.mycity.models.Category
import com.example.mycity.models.Place

class CityRepository {

    val categories: List<Category> = listOf(
        Category("coffee", "Coffee", Icons.Filled.Coffee),
        Category("restaurants", "Restaurants", Icons.Filled.Restaurant),
        Category("parks", "Parks", Icons.Filled.Park),
        Category("kids", "Kid-friendly", Icons.Filled.ChildCare),
        Category("shopping", "Shopping", Icons.Filled.ShoppingBag),
    )

    val places: List<Place> = listOf(
        // Coffee
        Place(
            id = "coffee_1",
            categoryId = "coffee",
            name = "Sierra Coffee (Center)",
            shortDescription = "Cozy place with desserts and espresso.",
            details = "Good cappuccino, quiet tables for work, and fresh pastries.",
            address = "Bishkek, city center",
            imageRes = R.drawable.coffee_1
        ),
        Place(
            id = "coffee_2",
            categoryId = "coffee",
            name = "Kofeinya #1",
            shortDescription = "Quick coffee and snacks.",
            details = "Fast service, decent latte, good for takeaway.",
            address = "Bishkek",
            imageRes = R.drawable.coffee_2
        ),
        Place(
            id = "coffee_3",
            categoryId = "coffee",
            name = "Traveler’s Coffee",
            shortDescription = "Popular chain with big menu.",
            details = "Wide selection: coffee, teas, sandwiches. Good for groups.",
            address = "Bishkek",
            imageRes = R.drawable.coffee_3
        ),

        // Restaurants
        Place(
            id = "rest_1",
            categoryId = "restaurants",
            name = "Navat",
            shortDescription = "Traditional Kyrgyz/Central Asian cuisine.",
            details = "Plov, lagman, manty. Nice interior and big portions.",
            address = "Bishkek",
            imageRes = R.drawable.res_1
        ),
        Place(
            id = "rest_2",
            categoryId = "restaurants",
            name = "Arzu",
            shortDescription = "Local favorites, family friendly.",
            details = "Good salads and hot dishes; comfortable seating.",
            address = "Bishkek",
            imageRes = R.drawable.res_2
        ),
        Place(
            id = "rest_3",
            categoryId = "restaurants",
            name = "Faiza",
            shortDescription = "Affordable and popular.",
            details = "Busy at lunch. Try lagman and samsa.",
            address = "Bishkek",
            imageRes = R.drawable.res_3
        ),

        // Parks
        Place(
            id = "park_1",
            categoryId = "parks",
            name = "Oak Park (Dubovy Park)",
            shortDescription = "Central park with shade and sculptures.",
            details = "Nice for walking, photos, and a relaxed afternoon.",
            address = "Bishkek, center",
            imageRes = R.drawable.park_1
        ),
        Place(
            id = "park_2",
            categoryId = "parks",
            name = "Victory Park",
            shortDescription = "Monuments + open space.",
            details = "Good place for a calm walk and history monuments.",
            address = "Bishkek",
            imageRes = R.drawable.park_2
        ),
        Place(
            id = "park_3",
            categoryId = "parks",
            name = "Ata-Türk Park",
            shortDescription = "Large park, great for evenings.",
            details = "Wide paths, benches, and space for kids to run.",
            address = "Bishkek",
            imageRes = R.drawable.park_3
        ),

        // Kid-friendly
        Place(
            id = "kids_1",
            categoryId = "kids",
            name = "Bishkek Circus",
            shortDescription = "Shows for families.",
            details = "Check schedule. Great for kids who enjoy performances.",
            address = "Bishkek",
            imageRes = R.drawable.kid_1
        ),
        Place(
            id = "kids_2",
            categoryId = "kids",
            name = "Playland (Mall area)",
            shortDescription = "Indoor playground.",
            details = "Safe indoor play, good when weather is bad.",
            address = "Bishkek",
            imageRes = R.drawable.kid_2
        ),
        Place(
            id = "kids_3",
            categoryId = "kids",
            name = "Zoo (if open)",
            shortDescription = "Animals and walking paths.",
            details = "Family visit with kids. Best on weekends.",
            address = "Bishkek",
            imageRes = R.drawable.kid_3
        ),

        // Shopping
        Place(
            id = "shop_1",
            categoryId = "shopping",
            name = "Bishkek Park Mall",
            shortDescription = "Modern mall with cinema.",
            details = "Brands, food court, entertainment.",
            address = "Bishkek",
            imageRes = R.drawable.shop_1
        ),
        Place(
            id = "shop_2",
            categoryId = "shopping",
            name = "Asia Mall",
            shortDescription = "Shopping + cafes.",
            details = "Nice for evening walk and quick meals.",
            address = "Bishkek",
            imageRes = R.drawable.shop_2
        ),
        Place(
            id = "shop_3",
            categoryId = "shopping",
            name = "Osh Bazaar",
            shortDescription = "Big traditional market.",
            details = "Great for local products, spices, and souvenirs.",
            address = "Bishkek",
            imageRes = R.drawable.shop_3
        ),
    )

    fun getPlacesByCategory(categoryId: String): List<Place> =
        places.filter { it.categoryId == categoryId }

    fun findPlace(placeId: String): Place? =
        places.firstOrNull { it.id == placeId }

    fun findCategory(categoryId: String): Category? =
        categories.firstOrNull { it.id == categoryId }
}