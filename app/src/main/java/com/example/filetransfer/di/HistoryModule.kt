package com.example.filetransfer.di

import android.content.Context
import androidx.room.Room
import com.example.filetransfer.data.local.AppDatabase
import com.example.filetransfer.data.local.TransferHistoryDao
import com.example.filetransfer.data.repository.HistoryRepositoryImpl
import com.example.filetransfer.domain.repository.HistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HistoryModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "file_transfer.db").build()

    @Provides
    fun provideTransferHistoryDao(db: AppDatabase): TransferHistoryDao =
        db.transferHistoryDao()

    @Provides
    @Singleton
    fun provideHistoryRepository(dao: TransferHistoryDao): HistoryRepository =
        HistoryRepositoryImpl(dao)
}