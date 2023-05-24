package com.messir.REminder.domain.repository

import kotlinx.coroutines.flow.Flow

interface StoreCategoriesRepository {
    suspend fun insertCategory(categories: MutableList<String>)

    val getCategories: Flow<MutableList<String>?>
}