package com.financialtracker.app.domain

import com.financialtracker.app.data.Resource
import com.financialtracker.app.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}