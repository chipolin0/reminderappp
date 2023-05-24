package com.messir.REminder.domain.repository

import com.messir.REminder.ui.utils.enums.Theme
import kotlinx.coroutines.flow.Flow

interface StoreThemeRepository {
    val getTheme: Flow<Theme>

    suspend fun setTheme(theme: Theme)
}