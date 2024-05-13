package com.project.foodrecipes

import com.project.foodrecipes.model.ModelFilter
import org.junit.Assert.assertEquals
import org.junit.Test

class ModelFilterUnitTest {

    @Test
    fun testIdMeal() {
        val modelFilter = ModelFilter()
        modelFilter.idMeal = "Test Id"
        assertEquals("Test Id", modelFilter.idMeal)
    }

    @Test
    fun testStrMeal() {
        val modelFilter = ModelFilter()
        modelFilter.strMeal = "Test Meal"
        assertEquals("Test Meal", modelFilter.strMeal)
    }

    @Test
    fun testStrMealThumb() {
        val modelFilter = ModelFilter()
        modelFilter.strMealThumb = "Test Meal Thumb"
        assertEquals("Test Meal Thumb", modelFilter.strMealThumb)
    }
}
