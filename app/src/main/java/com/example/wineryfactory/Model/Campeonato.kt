package com.example.wineryfactory.Model

class Campeonato {

    var id: Int = 0
    var nome: String = ""
    var descricao: String = ""
    var regras: String = ""
    var inicio: String = ""
    var fim: String = ""
    var categoria: String = ""
    var idTimes: Int = 0

    constructor(nome: String, descricao: String, regras: String, inicio: String, fim: String) {
        this.nome = nome
        this.descricao = descricao
        this.regras = regras
        this.inicio = inicio
        this.fim = fim
    }
}