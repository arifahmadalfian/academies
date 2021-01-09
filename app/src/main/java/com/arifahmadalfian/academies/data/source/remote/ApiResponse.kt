package com.arifahmadalfian.academies.data.source.remote

class ApiResponse<T>(val status: StatusResponses, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponses.SUCCESS, body, null)

        fun <T> empty(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponses.EMPTY, body, msg)

        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponses.ERROR, body, msg)
    }
}