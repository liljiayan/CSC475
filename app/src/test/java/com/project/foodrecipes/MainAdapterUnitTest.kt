package com.project.foodrecipes

import android.content.Context
import android.view.View
import com.project.foodrecipes.adapter.MainAdapter
import com.project.foodrecipes.model.ModelMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

@Suppress("DEPRECATION")
class MainAdapterTest {

    // Mocked dependencies
    @Mock
    lateinit var mockContext: Context

    // Initialize MainAdapter
    private lateinit var mainAdapter: MainAdapter

    // Sample data for testing
    private val testData = listOf(
        ModelMain("Category 1", "image_url_1"),
        ModelMain("Category 2", "image_url_2")
    )

    @Before
    fun setup() {
        // Initialize mocks
        initMocks(this)

        // Initialize MainAdapter with test data
        mainAdapter = MainAdapter(mockContext, testData, null)
    }

    @Test
    fun getItemCount_returnsCorrectItemCount() {
        assertEquals(testData.size, mainAdapter.itemCount)
    }

    @Test
    fun onBindViewHolder_setsCorrectData() {
        // Mock views and data
        val viewHolder = MainAdapter.ViewHolder(View(mockContext))
        val position = 0
        val expectedData = testData[position]

        // Perform onBind
        mainAdapter.onBindViewHolder(viewHolder, position)

        // Verify that the correct data is set
        assertEquals(expectedData.strCategory, viewHolder.tvCategory.text)
        // You can add more assertions here for other view properties if needed
    }
}
