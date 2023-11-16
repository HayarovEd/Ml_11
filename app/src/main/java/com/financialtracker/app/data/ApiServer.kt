package com.financialtracker.app.data

import com.financialtracker.app.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("527/db.json")
    suspend fun getDataDb () : BaseDto
}