package com.example.filetransfer.domain.repository

import com.example.filetransfer.domain.model.CompletedTransfer
import com.example.filetransfer.domain.model.TransferRecord
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun observeHistory(): Flow<List<TransferRecord>>

    suspend fun save(transfer: CompletedTransfer)
}