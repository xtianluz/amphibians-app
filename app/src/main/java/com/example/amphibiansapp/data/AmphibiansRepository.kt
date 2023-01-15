package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.network.AmphibianApiService

interface AmphibiansRepository {
    suspend fun getAmphibiansItem(): List<Amphibian>
}

class NetworkAmphibiansRepository(private val amphibianApiService: AmphibianApiService) : AmphibiansRepository {
    override suspend fun getAmphibiansItem(): List<Amphibian> {
        return amphibianApiService.getAmphibians()
    }
}