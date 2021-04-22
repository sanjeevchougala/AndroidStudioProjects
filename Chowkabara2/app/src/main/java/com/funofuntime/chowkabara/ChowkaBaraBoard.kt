package com.funofuntime.chowkabara

class ChowkaBaraBoard() {
    val board : Array<Array<ArrayList<String>>> = arrayOf(arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()),arrayOf(arrayListOf()))
    val player1BtnsPath = arrayOf("01","00","10","20","30","40","41","42","43","44","34","24","14","04","03","13","23","33","32","31","21","11","12","22")
    val player2BtnsPath = arrayOf("30","40","41","42","43","44","34","24","14","04","03","02","01","00","10","11","12","13","23","33","32","31","21","22")
    val player3BtnsPath = arrayOf("43","44","34","24","14","04","03","02","01","00","10","20","30","40","41","31","21","11","12","13","23","33","32","22")
    val player4BtnsPath = arrayOf("14","04","03","02","01","00","10","20","30","40","41","42","43","44","34","33","32","31","21","11","12","13","23","22")
    val player1BtnTags :ArrayList<String> = arrayListOf("11","12","13","14")
    val player2BtnTags :ArrayList<String> = arrayListOf("21","22","23","24")
    val player3BtnTags :ArrayList<String> = arrayListOf("31","32","33","34")
    val player4BtnTags :ArrayList<String> = arrayListOf("41","42","43","44")
    var players : ArrayList<Player> = arrayListOf()

    fun addPlayer(player : Player){
        players.add(player)
    }
//    fun main() {
//
//        board[0][0].add("Hello1")
//        board[1][0].add("Hello2")
//        board[2][0].add("Hello3")
//        board[3][0].add("Hello4")
//        board[4][0].add("Hello5")
//
//        for( index in 0..4){
//            println("First element of $index array is :   " + board[index][0][0])
//        }

//    }

}