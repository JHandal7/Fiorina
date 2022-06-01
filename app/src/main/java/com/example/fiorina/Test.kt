package com.example.fiorina

class Test {
    fun sayHello(name:String){
       println("In sayHello function")
        println("Say hello to $name")
    }
    fun higherOrdenFunction(functionName: (name:String)->Unit,name:String){
        println("In higher orden function")
        println("Calling sayHello() function..... ")
        functionName(name)
    }
    fun main(){
        higherOrdenFunction(::sayHello,"Ninja")
    }

}