package com.example.filetransfer.data.repository

import com.example.filetransfer.domain.repository.HistoryRepository
import com.example.filetransfer.domain.repository.TransferRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@Singleton
class HistoryRecorder @Inject constructor(
    private val transferRepository: TransferRepository,
    private val historyRepository: HistoryRepository
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var job: Job? = null

    fun start() {
        if (job?.isActive == true) return
        job = scope.launch {
            transferRepository.completedTransfers.collect { transfer ->
                try {
                    historyRepository.save(transfer)
                } catch (e: CancellationException) {
                    throw e
                } catch (e: Exception) {
                    // Gagal simpan satu transfer tidak boleh menghentikan perekam.
                }
            }
        }
    }
}