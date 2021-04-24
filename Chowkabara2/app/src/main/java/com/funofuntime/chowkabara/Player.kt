package com.funofuntime.chowkabara

class Player(var id : Int, var name : String, var btnIcon : String) {
    var hasPasstoInnerLoop : Boolean = false
    var playing : Boolean = false
    var icons: ArrayList<Icon> = arrayListOf()

    fun setHasPasstoInnerLoopTrue(){
        hasPasstoInnerLoop = true
    }

    fun setHasPasstoInnerLoopFalse(){
        hasPasstoInnerLoop = false
    }

    fun setPlayingTrue(){
        playing = true
    }

    fun setPlayingFalse(){
        playing = false
    }
}