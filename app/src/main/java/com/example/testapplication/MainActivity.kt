package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val maxOneInput = listOf(1,1,0,1,1,1)
        val maxOneInput2 = listOf(1,0,0,1,0,1,1)
        val reverseWordInput = "Hello"
        val bracketsBalancedInputPositifCase = "{[()]}"
        val bracketsBalancedInputNegaativeCase = " {[(])}"

        Log.d("FineMaxOne : ", findMaxOnes(maxOneInput).toString())
        Log.d("FineMaxOne2 : ", findMaxOnes(maxOneInput2).toString())
        Log.d("ReverseWord : ", reverseWord(reverseWordInput))
        Log.d("HasBracketsBalanced : ", hasBracketsBalanced(bracketsBalancedInputPositifCase).toString())
        Log.d("HasBracketsBalanced2 : ", hasBracketsBalanced(bracketsBalancedInputNegaativeCase).toString())
    }

    private fun findMaxOnes(arrInt: List<Int>): Int {
        var count = 0
        var max = 0

        for (i in arrInt.indices) {
            if (arrInt[i] == 0) {
                count = 0
            } else {
                count++
            }

            max = if (count > max) count else max

        }
        return max
    }

    private fun reverseWord(inputStr: String): String{
        if(inputStr.isEmpty()) return inputStr
        return reverseWord(inputStr.substring(1)) + inputStr[0]
    }

    private fun hasBracketsBalanced(inputStr: String): Boolean {
        val stack = Stack<Char>()
        val map = mapOf(
            '(' to ')', ')' to '(',
            '[' to ']', ']' to '[',
            '{' to '}', '}' to '{'
        )
        inputStr.forEach { str ->
            when {
                stack.empty() -> stack.push(str)
                stack.peek() == map[str] -> stack.pop()
                else -> stack.push(str)
            }
        }
        return stack.empty()
    }
}