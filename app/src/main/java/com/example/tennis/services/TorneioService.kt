package com.example.tennis.services

import ipvc.mytennis.api.interfaces.ITorneioService
import mytennis.api.core.HttpClient
import mytennis.api.core.RequestResult
import mytennis.api.core.ResponseParser
import requests.torneio.CreateTorneioRequest
import requests.torneio.UpdateTorneioRequest
import responses.torneios.CreateTorneiosResponse
import responses.torneios.DeleteTorneioResponse
import responses.torneios.GetAllTorneiosResponse
import responses.torneios.GetTorneioByIDResponse
import responses.torneios.UpdateTorneioResponse

class TorneioService : HttpClient<ITorneioService>(ITorneioService::class.java) {

    suspend fun getTorneios(): RequestResult<GetAllTorneiosResponse> {
        return when (val response = request(api.getTorneios())) {
            is RequestResult.Success -> RequestResult.Success(
                code = response.code,
                message = response.message,
                data = ResponseParser.payload<GetAllTorneiosResponse>(response)
            )
            is RequestResult.Error -> response
        }
    }

    suspend fun createTorneio(body: CreateTorneioRequest): RequestResult<CreateTorneiosResponse> {
        return when (val response = request(api.createTorneio(body))) {
            is RequestResult.Success -> RequestResult.Success(
                code = response.code,
                message = response.message,
                data = ResponseParser.payload<CreateTorneiosResponse>(response)
            )
            is RequestResult.Error -> response
        }
    }

    suspend fun deleteTorneio(id: String): RequestResult<DeleteTorneioResponse> {
        return when (val response = request(api.deleteTorneio(id))) {
            is RequestResult.Success -> RequestResult.Success(
                code = response.code,
                message = response.message,
                data = ResponseParser.payload<DeleteTorneioResponse>(response)
            )
            is RequestResult.Error -> response
        }
    }

    suspend fun updateTorneio(id: String, body: UpdateTorneioRequest): RequestResult<UpdateTorneioResponse> {
        return when (val response = request(api.updateTorneio(id, body))) {
            is RequestResult.Success -> RequestResult.Success(
                code = response.code,
                message = response.message,
                data = ResponseParser.payload<UpdateTorneioResponse>(response)
            )
            is RequestResult.Error -> response
        }
    }

    suspend fun getTorneioById(id: String): RequestResult<GetTorneioByIDResponse> {
        return when (val response = request(api.getTorneioById(id))) {
            is RequestResult.Success -> RequestResult.Success(
                code = response.code,
                message = response.message,
                data = ResponseParser.payload<GetTorneioByIDResponse>(response)
            )
            is RequestResult.Error -> response
        }
    }
}