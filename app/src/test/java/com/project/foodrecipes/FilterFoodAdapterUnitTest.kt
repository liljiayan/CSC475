package com.project.foodrecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.foodrecipes.adapter.FilterFoodAdapter
import com.project.foodrecipes.model.ModelFilter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilterFoodAdapterTest {

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var mockViewGroup: ViewGroup

    @Mock
    private lateinit var mockLayoutInflater: LayoutInflater

    @Mock
    private lateinit var mockViewHolder: FilterFoodAdapter.ViewHolder

    @Mock
    private lateinit var mockOnSelectData: FilterFoodAdapter.OnSelectData

    private lateinit var adapter: FilterFoodAdapter

    private val testData = listOf(
        ModelFilter("1", "Test1","http://example.com/image1.jpg"),
        ModelFilter("2", "Test2", "http://example.com/image2.jpg")
    )

    @Before
    fun setUp() {
        `when`(mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(mockLayoutInflater)
        `when`(mockLayoutInflater.inflate(R.layout.list_item_filter_food, mockViewGroup, false)).thenReturn(mock(View::class.java))
        adapter = FilterFoodAdapter(mockContext, testData, mockOnSelectData)
    }

    @Test
    fun testOnBindViewHolder() {
        adapter.onBindViewHolder(mockViewHolder, 0)

        // Verify that the text is set correctly
        verify(mockViewHolder).tvMeal.text = testData[0].strMeal

        // You can add more verification for other views here if needed
    }
}
