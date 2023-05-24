package com.messir.REminder.ui.screens.reminders

import remindersdb.ReminderEntity

sealed class RemindersListEvents {
    object OnSearchClick: RemindersListEvents()
    object OnSettingsClick : RemindersListEvents()
    object OnFilterClick : RemindersListEvents()
    data class OnReminderClick(val reminder: ReminderEntity) : RemindersListEvents()
    object OnAddClick : RemindersListEvents()
}