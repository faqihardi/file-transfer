package com.example.filetransfer.data.repository

import com.example.filetransfer.domain.model.CompletedTransfer
import com.example.filetransfer.domain.model.IncomingFileMeta
import com.example.filetransfer.domain.model.TransferRecord
import com.example.filetransfer.domain.model.toRecord
import com.example.filetransfer.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class FakeHistoryRepository : HistoryRepository {

    private val records = MutableStateFlow(
        listOf(
            TransferRecord(
                id = 1,
                transferId = "fake-1",
                peerName = "Samsung A54",
                direction = CompletedTransfer.Direction.SENT,
                message = "Oke, ini ya",
                files = listOf(
                    IncomingFileMeta("foto_kelas.jpg", 4_400_000),
                    IncomingFileMeta("tugas_pbo.pdf", 4_400_000)
                ),
                timestampMillis = 1_790_000_000_000
            ),
            TransferRecord(
                id = 2,
                transferId = "fake-2",
                peerName = "Redmi Note 12",
                direction = CompletedTransfer.Direction.RECEIVED,
                files = listOf(IncomingFileMeta("materi_kuliah.zip", 12_000_000)),
                timestampMillis = 1_789_900_000_000
            )
        )
    )

    override fun observeHistory(): Flow<List<TransferRecord>> =
        records.map { list -> list.sortedByDescending { it.timestampMillis } }

    override suspend fun save(transfer: CompletedTransfer) {
        val nextId = (records.value.maxOfOrNull { it.id } ?: 0) + 1
        records.value = records.value + transfer.toRecord().copy(id = nextId)
    }
}