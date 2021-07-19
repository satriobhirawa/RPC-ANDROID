package com.example.rpc_android

import android.widget.ImageView


class GameLogic {



    fun gameCondition(playerInput: String, comInput: String): String {

        when {
            ((playerInput == "playerOneGunting" && comInput == "comKertas") ||
                    (playerInput == "playerOneBatu" && comInput == "comGunting") ||
                    (playerInput == "playerOneKertas" && comInput == "comBatu")
                    ) -> {
                return result("PlayerOneWin")
            }

            ((comInput == "comGunting" && playerInput == "playerOneKertas") ||
                    (comInput == "comBatu" && playerInput == "playerOneGunting") ||
                    (comInput == "comKertas" && playerInput == "playerOneBatu")
                    ) -> {
                return result("ComWin")
            }
            else -> {
                return result("invalid")
            }
        }


    }

    fun randomInputCom(arr: Array<ImageView>): ImageView {
        val rand = (0..2).random()
        return arr[rand]
    }

    fun playerInput(input: String): String {
        return input
    }

    fun result(res: String): String {
        return res
    }
}