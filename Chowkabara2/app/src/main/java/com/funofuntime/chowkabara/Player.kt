package com.funofuntime.chowkabara

class Player(var name : String, var btnIcon : String) {
    var hasPasstoInnerLoop : Boolean = false
    var playing : Boolean = false

    fun setHasPasstoInnerLoopTrue(){
        hasPasstoInnerLoop = true
    }

    fun setHasPasstoInnerLoopFalse(){
        hasPasstoInnerLoop = false
    }

    fun setPlayingTrue(){
        hasPasstoInnerLoop = true
    }

    fun setPlayingFalse(){
        hasPasstoInnerLoop = false
    }
}