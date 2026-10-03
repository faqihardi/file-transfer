package com.example.filetransfer.data.repository

import com.example.filetransfer.data.local.TransferHistoryDao
import com.example.filetransfer.data.mapper.toDomain
import com.example.filetransfer.data.mapper.toEntity
import com.example.filetransfer.domain.model.CompletedTransfer
import com.example.filetransfer.domain.model.TransferRecord
import com.example.filetransfer.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(
    private val dao: TransferHistoryDao
) : HistoryRepository {

    override fun observeHistory(): Flow<List<TransferRecord>> =
        dao.observeAll().map { list -> list.map { it.toDomain() } }

    override suspend fun save(transfer: CompletedTransfer) {
        dao.insert(transfer.toEntity())
    }
}