package com.example.filetransfer.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "transfer_records",
    indices = [Index(value = ["transferId"], unique = true)]
)
data class TransferRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val transferId: String,
    val peerName: String,
    val direction: String,
    val message: String,
    val filesJson: String,
    val timestampMillis: Long
)