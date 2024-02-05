package com.example.hstoneapp.domain.model

import com.google.gson.annotations.SerializedName

data class InfoFilterEntity(
    @SerializedName("patch")
    val patch: String? = null,
    @SerializedName("classes")
    val classes: List<String>? = null,
    @SerializedName("sets")
    val sets: List<String>? = null,
    @SerializedName("standard")
    val standard: List<String>? = null,
    @SerializedName("wild")
    val wild: List<String>? = null,
    @SerializedName("types")
    val types: List<String>? = null,
    @SerializedName("factions")
    val factions: List<String>? = null,
    @SerializedName("qualities")
    val qualities: List<String>? = null,
    @SerializedName("races")
    val races: List<String>? = null,
    @SerializedName("locales")
    val locales: Locales? = null
)

data class Locales(
    @SerializedName("DE_DE")
    val deDe: String,
    @SerializedName("EN_GB")
    val enGB: String,
    @SerializedName("EN_US")
    val enUs: String,
    @SerializedName("ES_ES")
    val esEs: String,
    @SerializedName("ES_MX")
    val esMX: String,
    @SerializedName("FR_FR")
    val frFr: String,
    @SerializedName("IT_IT")
    val itIt: String,
    @SerializedName("KO_KR")
    val koKr: String,
    @SerializedName("PL_PL")
    val plPl: String,
    @SerializedName("PT_BR")
    val ptBr: String,
    @SerializedName("RU_RU")
    val ruRu: String,
    @SerializedName("ZH_CN")
    val zhCN: String,
    @SerializedName("ZH_TW")
    val zhTw: String,
    @SerializedName("JA_JP")
    val jaJp: String,
    @SerializedName("TH_TH")
    val thTh: String
)
