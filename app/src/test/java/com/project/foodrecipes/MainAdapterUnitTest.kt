package com.project.foodrecipes

import android.content.Context
import android.view.ViewGroup
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.project.foodrecipes.adapter.MainAdapter
import com.project.foodrecipes.model.ModelMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainAdapterTest {

    private lateinit var context: Context
    private lateinit var testItems: List<ModelMain>

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        testItems = listOf(
            ModelMain("Category 1", "Category Thumb 1", "Category Description 1"),
            ModelMain("Category 2", "Category Thumb 2", "Category Description 2")
        )
    }

    @Test
    fun testAdapterItemCount() {
        val adapter = MainAdapter(context, testItems, null)
        assertEquals(testItems.size, adapter.itemCount)
    }

    @Test
    fun testViewHolder() {
        val parent = object : ViewGroup(context) {
            override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
                // Do nothing
            }
        }

        val adapter = MainAdapter(context, testItems, null)
        val viewHolder = adapter.onCreateViewHolder(parent, 0)

        assertNotNull(viewHolder)
        assertNotNull(viewHolder.tvCategory)
        assertNotNull(viewHolder.imgCategory)
        assertNotNull(viewHolder.cvCategory)
    }

    @Test
    fun testOnBindViewHolder() {
        val parent = object : ViewGroup(context) {
            override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
                // Do nothing
            }
        }

        val mockSelectData: MainAdapter.OnSelectData = object : MainAdapter.OnSelectData {
            override fun onSelected(modelMain: ModelMain) {
                // Do nothing
            }
        }

        val adapter = MainAdapter(context, testItems, mockSelectData)
        val viewHolder = adapter.onCreateViewHolder(parent, 0)

        adapter.onBindViewHolder(viewHolder, 0)
        assertEquals(testItems[0].strCategory, viewHolder.tvCategory.text.toString())
    }
}
