package com.project.foodrecipes

import android.content.Context
import android.view.View
import com.project.foodrecipes.adapter.FilterFoodAdapter
import com.project.foodrecipes.model.ModelFilter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

@Suppress("DEPRECATION")
class FilterFoodAdapterTest {

    // Mocked dependencies
    @Mock
    lateinit var mockContext: Context

    @Mock
    lateinit var mockOnSelectData: FilterFoodAdapter.OnSelectData

    // Initialize FilterFoodAdapter
    private lateinit var filterFoodAdapter: FilterFoodAdapter

    // Sample data for testing
    private val testData = listOf(
        ModelFilter("Meal 1", "image_url_1"),
        ModelFilter("Meal 2", "image_url_2")
    )

    @Before
    fun setup() {
        // Initialize mocks
        initMocks(this)

        // Initialize FilterFoodAdapter with test data
        filterFoodAdapter = FilterFoodAdapter(mockContext, testData, mockOnSelectData)
    }

    @Test
    fun getItemCount_returnsCorrectItemCount() {
        assertEquals(testData.size, filterFoodAdapter.itemCount)
    }

    @Test
    fun onBindViewHolder_setsCorrectData() {
        // Mock views and data
        val viewHolder = FilterFoodAdapter.ViewHolder(View(mockContext))
        val position = 0
        val expectedData = testData[position]

        // Perform onBind
        filterFoodAdapter.onBindViewHolder(viewHolder, position)

        // Verify that the correct data is set
        assertEquals(expectedData.strMeal, viewHolder.tvMeal.text)
        // You can add more assertions here for other view properties if needed
    }

    @Test
    fun onBindViewHolder_clickListenerInvoked() {
        // Mock views and data
        val viewHolder = FilterFoodAdapter.ViewHolder(View(mockContext))
        val position = 0
        val expectedData = testData[position]

        // Perform onBind
        filterFoodAdapter.onBindViewHolder(viewHolder, position)

        // Trigger click listener
        viewHolder.cvFilterMeal.performClick()

        // Verify that the onSelectData callback is invoked with the correct data
        verify(mockOnSelectData).onSelected(expectedData)
    }
}