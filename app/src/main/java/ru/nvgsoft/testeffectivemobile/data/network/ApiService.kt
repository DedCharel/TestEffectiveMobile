package ru.nvgsoft.testeffectivemobile.data.network

import retrofit2.http.GET
import ru.nvgsoft.testeffectivemobile.data.network.dto.ResponseDto

interface ApiService {

    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getData(): ResponseDto
}