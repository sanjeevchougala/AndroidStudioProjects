package com.funofuntime.chowkabara

object ChowkaBaraBoard {
    val board : Array<Array<ArrayList<String>>> = arrayOf(arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()))
    val player1BtnsPath = arrayOf("13","12","11","21","31","41","51","52","53","54","55","45","35","25","15","14","24","34","44","43","42","32","22","23","33")
    val player2BtnsPath = arrayOf("31","41","51","52","53","54","55","45","35","25","15","14","13","12","11","21","22","23","24","34","44","43","42","22","33")
    val player3BtnsPath = arrayOf("53","54","55","45","35","25","15","14","13","12","11","21","31","41","51","52","42","32","22","23","24","34","44","43","33")
    val player4BtnsPath = arrayOf("35","25","15","14","13","12","11","21","31","41","51","52","53","54","55","45","44","43","42","32","22","23","24","34","33")
    var btnPath = mutableMapOf("1" to player1BtnsPath, "2" to player2BtnsPath, "3" to player3BtnsPath, "4" to player4BtnsPath)
    var players : ArrayList<Player> = arrayListOf()
    var currentPlayer :Int = 0
    var diceRolled = false
    var diceValue = 0
    val homeCells :ArrayList<String> = arrayListOf("cell33","cell13","cell31","cell53","cell35")
    var innerCells = arrayOf("24","34","44","43","42","32","22","23","33")

    val cells = mutableMapOf(
            "cell11" to ArrayList<Icon>(),
            "cell12" to ArrayList<Icon>(),
            "cell13" to ArrayList<Icon>(),
            "cell14" to ArrayList<Icon>(),
            "cell15" to ArrayList<Icon>(),
            "cell21" to ArrayList<Icon>(),
            "cell22" to ArrayList<Icon>(),
            "cell23" to ArrayList<Icon>(),
            "cell24" to ArrayList<Icon>(),
            "cell25" to ArrayList<Icon>(),
            "cell31" to ArrayList<Icon>(),
            "cell32" to ArrayList<Icon>(),
            "cell33" to ArrayList<Icon>(),
            "cell34" to ArrayList<Icon>(),
            "cell35" to ArrayList<Icon>(),
            "cell41" to ArrayList<Icon>(),
            "cell42" to ArrayList<Icon>(),
            "cell43" to ArrayList<Icon>(),
            "cell44" to ArrayList<Icon>(),
            "cell45" to ArrayList<Icon>(),
            "cell51" to ArrayList<Icon>(),
            "cell52" to ArrayList<Icon>(),
            "cell53" to ArrayList<Icon>(),
            "cell54" to ArrayList<Icon>(),
            "cell55" to ArrayList<Icon>())

    fun clearBoard(){
        currentPlayer = 0
        diceRolled = false
        diceValue = 0
        cells["cell11"]?.clear()
        cells["cell12"]?.clear()
        cells["cell13"]?.clear()
        cells["cell14"]?.clear()
        cells["cell15"]?.clear()
        cells["cell21"]?.clear()
        cells["cell22"]?.clear()
        cells["cell23"]?.clear()
        cells["cell24"]?.clear()
        cells["cell25"]?.clear()
        cells["cell31"]?.clear()
        cells["cell32"]?.clear()
        cells["cell33"]?.clear()
        cells["cell34"]?.clear()
        cells["cell35"]?.clear()
        cells["cell41"]?.clear()
        cells["cell42"]?.clear()
        cells["cell43"]?.clear()
        cells["cell44"]?.clear()
        cells["cell45"]?.clear()
        cells["cell51"]?.clear()
        cells["cell52"]?.clear()
        cells["cell53"]?.clear()
        cells["cell54"]?.clear()
        cells["cell55"]?.clear()
    }
}
