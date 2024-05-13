package com.project.foodrecipes

import com.project.foodrecipes.model.ModelMain
import org.junit.Assert.assertEquals
import org.junit.Test

class MainAdapterUnitTest {

    @Test
    fun testStrCategory() {
        val modelMain = ModelMain()
        modelMain.strCategory = "Test Category"
        assertEquals("Test Category", modelMain.strCategory)
    }

    @Test
    fun testStrCategoryThumb() {
        val modelMain = ModelMain()
        modelMain.strCategoryThumb = "Test Category Thumb"
        assertEquals("Test Category Thumb", modelMain.strCategoryThumb)
    }

    @Test
    fun testStrCategoryDescription() {
        val modelMain = ModelMain()
        modelMain.strCategoryDescription = "Test Category Description"
        assertEquals("Test Category Description", modelMain.strCategoryDescription)
    }
}
