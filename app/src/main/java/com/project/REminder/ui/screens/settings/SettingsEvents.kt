package com.messir.REminder.ui.screens.settings

import com.messir.REminder.ui.utils.enums.Theme

sealed class SettingsEvents {
    data class OnChangeThemeClick(val theme: Theme): SettingsEvents()
    object OnNavigationIconClick: SettingsEvents()
    data class SendFeedback(val text: String): SettingsEvents()
    data class ToggleFeedbackAlert(val isOpen: Boolean): SettingsEvents()
}