package com.liljiayan.foodrecipes

import androidx.test.core.app.ApplicationProvider
import com.liljiayan.foodrecipes.adapter.FilterFoodAdapter
import com.liljiayan.foodrecipes.model.ModelFilter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FilterFoodAdapterTest {

    // Initialize FilterFoodAdapter
    private lateinit var filterFoodAdapter: FilterFoodAdapter

    // Sample data for testing
    private val testData = listOf(
        ModelFilter("Meal 1", "image_url_1"),
        ModelFilter("Meal 2", "image_url_2")
    )

    @Before
    fun setup() {
        // Initialize FilterFoodAdapter with test data
        filterFoodAdapter = FilterFoodAdapter(
            ApplicationProvider.getApplicationContext(),
            testData,
            object : FilterFoodAdapter.OnSelectData {
                override fun onSelected(modelMain: ModelFilter) {
                    // Handle selection if needed for testing
                }
            })
    }

    @Test
    fun getItemCount_returnsCorrectItemCount() {
        assertEquals(testData.size, filterFoodAdapter.itemCount)
    }
}