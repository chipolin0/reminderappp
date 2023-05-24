package com.messir.REminder.ui.screens.create_reminder

import com.messir.REminder.domain.model.Reminder

sealed class CreateReminderEvents {
    data class OnCreateReminderClick(val reminder: Reminder): CreateReminderEvents()
    object OnCancelClick: CreateReminderEvents()

    /* Alert dialog */
    object OpenCreateCategoryAlert: CreateReminderEvents()
    object DismissCreateCategoryAlert: CreateReminderEvents()

    /* Pickers */
    object OpenTimePicker: CreateReminderEvents()
    object DismissTimePicker: CreateReminderEvents()
    object OpenDatePicker: CreateReminderEvents()
    object DismissDatePicker: CreateReminderEvents()

    /* Dropdown */
    data class ToggleDropdown(val isOpen: Boolean): CreateReminderEvents()

    data class ToggleCheckBox(val isChecked: Boolean): CreateReminderEvents()

    data class InsertCategory(val categories: MutableList<String>): CreateReminderEvents()
}