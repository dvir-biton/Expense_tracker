package com.fylora.expensetracker.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fylora.expensetracker.ExpenseApplication
import com.fylora.expensetracker.core.Constants
import com.fylora.expensetracker.feature_expense.data.data_source.ExpenseDatabase
import com.fylora.expensetracker.feature_expense.data.repository.ExpenseRepositoryImpl
import com.fylora.expensetracker.feature_expense.domain.repository.ExpenseRepository
import com.fylora.expensetracker.feature_expense.domain.use_cases.CalculateTotalUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.GetExpensesUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.UpsertExpenseUseCase
import com.fylora.expensetracker.feature_expense.domain.use_cases.UseCases
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
    fun provideDatabase(app: Application): ExpenseDatabase {
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

    @Provides
    @Singleton
    fun provideUseCases(repository: ExpenseRepository): UseCases {
        return UseCases(
            calculateTotalUseCase = CalculateTotalUseCase(),
            upsertExpenseUseCase = UpsertExpenseUseCase(repository),
            getExpensesUseCase = GetExpensesUseCase(repository)
        )
    }
}