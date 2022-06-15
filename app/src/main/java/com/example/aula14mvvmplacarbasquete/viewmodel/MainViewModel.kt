package com.example.aula14mvvmplacarbasquete.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var teamOne = 0
    private var teamTwo = 0

    //tem que declarar duas variáveis, onde uma é mutavel e a outra não
    // o underline é uma boa prática para diferenciar a variável da variavel mutavel
    private val _teamOnePoints : MutableLiveData<Int> = MutableLiveData() // vai deixar essa variavel privada para a view model, para não deixar a view modificar ela // Aqui tem métodos para mudar a variável
    val teamOnePoints : LiveData<Int> // aqui tem métodos para observar a variável
        get() = _teamOnePoints

    private val _teamOTwoPoints : MutableLiveData<Int> = MutableLiveData() // aqui tem métodos para adicionar um valor a essa variável
    val teamTwoPoints : LiveData<Int> // aqui tem métodos para observar a variável
        get() = _teamOTwoPoints

    fun addPointsTeamOne(points: Int) {
        teamOne += points // vai recuperar os métodos do primeiro time
        _teamOnePoints.postValue(teamOne) // vai setar o valor do primeiro time
        //o .postValue vai postar o valor da variável
    }

    fun addpointsTeamTwo(points: Int){
        teamTwo += points
        _teamOTwoPoints.postValue(teamTwo) // o .postValue é um método do MutableLiveData, pois não dá para atribuir o valor diretamente na variável, não da para a variável receber diretamente a pontuação
    }

    fun cleanPoints() {
        teamOne = 0
        teamTwo = 0
        _teamOnePoints.postValue(teamOne)
        _teamOTwoPoints.postValue(teamTwo)
    }


}