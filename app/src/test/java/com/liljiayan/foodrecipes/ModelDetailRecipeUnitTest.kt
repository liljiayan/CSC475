package com.liljiayan.foodrecipes

import com.liljiayan.foodrecipes.model.ModelDetailRecipe
import org.junit.Assert
import org.junit.Test

class ModelDetailRecipeUnitTest {
    @Test
    fun testStrMeal() {
        val modelDetailRecipe = ModelDetailRecipe()
        modelDetailRecipe.strMeal = "Test Meal"
        Assert.assertEquals("Test Meal", modelDetailRecipe.strMeal)
    }

    @Test
    fun testStrCategory() {
        val modelDetailRecipe = ModelDetailRecipe()
        modelDetailRecipe.strCategory = "Test Category"
        Assert.assertEquals("Test Category", modelDetailRecipe.strCategory)
    }

    @Test
    fun testStrArea() {
        val modelDetailRecipe = ModelDetailRecipe()
        modelDetailRecipe.strArea = "Test Area"
        Assert.assertEquals("Test Area", modelDetailRecipe.strArea)
    }
}