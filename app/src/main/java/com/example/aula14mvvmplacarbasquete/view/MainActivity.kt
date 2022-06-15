package com.example.aula14mvvmplacarbasquete.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aula14mvvmplacarbasquete.databinding.ActivityMainBinding
import com.example.aula14mvvmplacarbasquete.viewmodel.MainViewModel



class MainActivity : AppCompatActivity() {
    //1234
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModelProvider garante que a vielModel vai ficar associada ao ciclo de vida da activity ou fragment,  começa quando a activity iniciar e termina quando a activity terminar
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setUpClickListeners() //3.
        setUpObservers()

    }

    //4.

    // Pegar todos os botões a adicionar clicks a eles
    private fun setUpClickListeners(){
        binding.apply {
            btn3PointsOne.setOnClickListener {
                viewModel.addPointsTeamOne(3)
            }
            btn2PointsOne.setOnClickListener {
                viewModel.addPointsTeamOne(2)
            }
            btnFreeThrowOne.setOnClickListener {
                viewModel.addPointsTeamOne(1)
            }

            btn3PointsTwo.setOnClickListener {
                viewModel.addpointsTeamTwo(3)
            }

            btn2PointsTwo.setOnClickListener {
                viewModel.addpointsTeamTwo(2)
            }
            btnFreeThrowTwo.setOnClickListener {
                viewModel.addpointsTeamTwo(1)
            }

            btnCleanPoints.setOnClickListener {
                viewModel.cleanPoints()
            }
        }
    }

    private fun setUpObservers () {
        //como a viewModel lá em cima está declarada null, a daqi de baixo tambem tem que estar null com a ? (interrogação)
        viewModel.apply {

            // vai pegar a pontuação do time 1, vai observar ela, toda vez que aquela variavel mudar, eu vou modificar na tela
            //também tem que falar o contexto de quem está observando(que é essam mesma activity(this@MainActivity), chamar o Observer
            //e o retorno no it é um Int //por exemplo: se lá na activity MainViewmodel os pontos fossem String, o it retornaria String) // Aqui está recebendo o tipo da variável que foi declarada anteriormente, o valor dela
            teamOnePoints.observe(this@MainActivity, Observer {
                binding.tvPointTeamOne.text = it.toString() // vai receber o it que é o valor dospontos do time one e colocar o .toString pq era Int
            })

            teamTwoPoints.observe(this@MainActivity, Observer {
                binding.tvPointTeamTwo.text = it.toString() // vai receber o it que é o valor dospontos do time one e colocar o .toString pq era Int
            })
        }

    }
}