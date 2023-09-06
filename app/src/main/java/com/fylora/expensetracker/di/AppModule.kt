package com.fylora.expensetracker.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.fylora.expensetracker.ExpenseApplication
import com.fylora.expensetracker.core.Constants
import com.fylora.expensetracker.feature_expense.data.data_source.ExpenseDatabase
import com.fylora.expensetracker.feature_expense.data.repository.ExpenseRepositoryImpl
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: ExpenseApplication): ExpenseDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = ExpenseDatabase::class.java,
            name = Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(database: ExpenseDatabase): ExpenseRepository {
        return ExpenseRepositoryImpl(database.dao)
    }
}