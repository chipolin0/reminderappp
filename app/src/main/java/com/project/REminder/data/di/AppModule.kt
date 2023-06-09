package com.messir.REminder.data.di

import android.app.Application
import com.messir.REminder.RemindersDatabase
import com.messir.REminder.data.repository.datastore.StoreCategoriesRepositoryImpl
import com.messir.REminder.data.reminders_db.RemindersDataSourceImpl
import com.messir.REminder.data.reminders_db.RemindersDataSource
import com.messir.REminder.data.reminders_db.RemindersDatabaseAdapters
import com.messir.REminder.data.repository.datastore.StoreThemeRepositoryImpl
import com.messir.REminder.domain.repository.StoreCategoriesRepository
import com.messir.REminder.domain.repository.StoreThemeRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import remindersdb.ReminderEntity
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().addLast(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver = AndroidSqliteDriver(
        schema = RemindersDatabase.Schema,
        context = app,
        name = "reminders.db"
    )

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    fun provideReminderDataSource(driver: SqlDriver): RemindersDataSource =
        RemindersDataSourceImpl(
            db = RemindersDatabase(
                driver = driver, ReminderEntityAdapter = ReminderEntity.Adapter(
                    categoriesAdapter = RemindersDatabaseAdapters.listOfStringsAdapter,
                    repeatAdapter = RemindersDatabaseAdapters.repeatAdapter,
                    colorAdapter = RemindersDatabaseAdapters.colorAdapter,
                    dateAdapter = RemindersDatabaseAdapters.dateAdapter
                )
            )
        )

    @Provides
    @Singleton
    fun provideStoreCategories(app: Application): StoreCategoriesRepository = StoreCategoriesRepositoryImpl(context = app)

    @Provides
    @Singleton
    fun provideTheme(app: Application): StoreThemeRepository = StoreThemeRepositoryImpl(context = app)
}