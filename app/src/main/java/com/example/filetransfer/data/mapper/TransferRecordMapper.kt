package com.example.filetransfer.data.mapper

import com.example.filetransfer.data.local.TransferRecordEntity
import com.example.filetransfer.domain.model.CompletedTransfer
import com.example.filetransfer.domain.model.IncomingFileMeta
import com.example.filetransfer.domain.model.TransferRecord
import org.json.JSONArray
import org.json.JSONObject

fun CompletedTransfer.toEntity(): TransferRecordEntity = TransferRecordEntity(
    transferId = transferId,
    peerName = peerName,
    direction = direction.name,
    message = message,
    filesJson = files.toJson(),
    timestampMillis = timestampMillis
)

fun TransferRecordEntity.toDomain(): TransferRecord = TransferRecord(
    id = id,
    transferId = transferId,
    peerName = peerName,
    direction = CompletedTransfer.Direction.valueOf(direction),
    message = message,
    files = filesFromJson(filesJson),
    timestampMillis = timestampMillis
)

private fun List<IncomingFileMeta>.toJson(): String {
    val array = JSONArray()
    forEach { file ->
        array.put(
            JSONObject()
                .put("name", file.name)
                .put("size", file.sizeBytes)
        )
    }
    return array.toString()
}

private fun filesFromJson(json: String): List<IncomingFileMeta> {
    val array = JSONArray(json)
    return List(array.length()) { index ->
        val obj = array.getJSONObject(index)
        IncomingFileMeta(
            name = obj.getString("name"),
            sizeBytes = obj.getLong("size")
        )
    }
}