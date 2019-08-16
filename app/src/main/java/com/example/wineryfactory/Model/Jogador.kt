package com.example.wineryfactory.Model

class Jogador {
    var id : Int = 0
    var nome: String = ""
    var nick: String = ""
    var email: String = ""
    var funcao: String = ""
    var telefone: String = ""
    var idTimes: Int = 0

    constructor(nome:String,nick:String,email:String,funcao:String,telefone:String){
        this.nome = nome
        this.nick = nick
        this.email = email
        this.funcao = funcao
        this.telefone = telefone
    }
}