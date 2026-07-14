package com.moisesdias.activityfragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import java.io.Serializable

/*
data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacoes: Double,
    val diretor: String,
    val distribuidor: String,
    val classificacao: Int
) : Serializable*/

@Parcelize
data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacoes: Double,
    val diretor: String,
    val distribuidor: String,
    val classificacao: Int
) : Parcelable