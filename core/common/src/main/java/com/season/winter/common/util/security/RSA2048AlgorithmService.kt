package com.season.winter.common.util.security

interface RSA2048AlgorithmService {
    fun create(alias: String): Boolean

    fun encrypt(plainText: String): String

    fun decrypt(base64EncryptedCipherText: String): String
}