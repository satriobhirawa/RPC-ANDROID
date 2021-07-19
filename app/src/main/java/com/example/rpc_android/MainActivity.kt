package com.example.rpc_android

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var userInput: String = ""
    var comInput: String = ""
    val gameLogic = GameLogic()
    val ivStats by lazy { findViewById<ImageView>(R.id.ivResult) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val comChoiceBatu: ImageView = findViewById(R.id.comBatu)
        val comChoiceGunting: ImageView = findViewById(R.id.comGunting)
        val comChoiceKertas: ImageView = findViewById(R.id.comKertas)


        val arrComChoice = arrayOf(comChoiceBatu, comChoiceGunting, comChoiceKertas)

        val playerOneBatu: ImageView = findViewById(R.id.playerOneBatu)
        playerOneBatu.setOnClickListener {
            val comChoice = gameLogic.randomInputCom(arrComChoice)

            userInput += gameLogic.playerInput("playerOneBatu")
            comInput += resources.getResourceEntryName(comChoice.id)

            playerOneBatu.setBackgroundResource(R.drawable.select)
            comChoice.setBackgroundResource(R.drawable.select)

            gameResult(gameLogic.gameCondition(userInput, comInput))
            Log.i("input","$userInput vs $comInput")
            Log.i("status", "${gameResult(
                gameLogic.gameCondition(userInput, comInput)
            )}")

            userInput = ""
            comInput = ""
        }
        val playerOneGunting: ImageView = findViewById(R.id.playerOneGunting)
        playerOneGunting.setOnClickListener {
            val comChoice = gameLogic.randomInputCom(arrComChoice)
            userInput += gameLogic.playerInput("playerOneGunting")
            comInput += resources.getResourceEntryName(comChoice.id)

            playerOneGunting.setBackgroundResource(R.drawable.select)
            comChoice.setBackgroundResource(R.drawable.select)
            gameResult(gameLogic.gameCondition(userInput, comInput))
            Log.i("input","$userInput vs $comInput")
            Log.i("status", "${gameResult(
                gameLogic.gameCondition(userInput, comInput)
            )}")

            userInput = ""
            comInput = ""
        }
        val playerOneKertas: ImageView = findViewById(R.id.playerOneKertas)
        playerOneKertas.setOnClickListener {
            val comChoice = gameLogic.randomInputCom(arrComChoice)
            userInput += gameLogic.playerInput("playerOneKertas")
            comInput += resources.getResourceEntryName(comChoice.id)

            playerOneKertas.setBackgroundResource(R.drawable.select)
            comChoice.setBackgroundResource(R.drawable.select)

            gameResult(gameLogic.gameCondition(userInput, comInput))
            Log.i("input","$userInput vs $comInput")
            Log.i("status", "${gameResult(
                gameLogic.gameCondition(userInput, comInput)
            )}")

            userInput = ""
            comInput = ""
        }

        val btnReset : ImageView = findViewById(R.id.ivRefresh)
        btnReset.setOnClickListener{
            userInput = ""
            comInput = ""
            ivStats.setImageResource(R.drawable.vs)
            comChoiceBatu.setBackgroundResource(R.color.white)
            comChoiceGunting.setBackgroundResource(R.color.white)
            comChoiceKertas.setBackgroundResource(R.color.white)
            playerOneBatu.setBackgroundResource(R.color.white)
            playerOneGunting.setBackgroundResource(R.color.white)
            playerOneKertas.setBackgroundResource(R.color.white)

        }

    }

    private fun gameResult(arg: String){

        when(arg){
            "PlayerOneWin" -> {ivStats.setImageResource(R.drawable.p1menang)}
            "ComWin" -> {ivStats.setImageResource(R.drawable.p2menang)}
            else -> ivStats.setImageResource(R.drawable.draw)
        }

    }


}