package com.liljiayan.foodrecipes

import com.liljiayan.foodrecipes.networking.Api
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiUnitTest {

    @Test
    fun testCategoriesUrl() {
        assertEquals("https://www.themealdb.com/api/json/v1/1/categories.php", Api.Categories)
    }

    @Test
    fun testFilterUrl() {
        val expectedUrl = "https://www.themealdb.com/api/json/v1/1/filter.php?c={strCategory}"
        assertEquals(expectedUrl, Api.Filter)
    }

    @Test
    fun testDetailRecipeUrl() {
        val expectedUrl = "https://www.themealdb.com/api/json/v1/1/lookup.php?i={idMeal}"
        assertEquals(expectedUrl, Api.DetailRecipe)
    }
}