package com.example.filetransfer.domain.model

data class TransferRecord(
    val id: Long = 0,
    val transferId: String,
    val peerName: String,
    val direction: CompletedTransfer.Direction,
    val message: String = "",
    val files: List<IncomingFileMeta> = emptyList(),
    val timestampMillis: Long
)

fun CompletedTransfer.toRecord(): TransferRecord = TransferRecord(
    transferId = transferId,
    peerName = peerName,
    direction = direction,
    message = message,
    files = files,
    timestampMillis = timestampMillis
)