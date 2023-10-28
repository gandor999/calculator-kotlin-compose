package com.example.calculator_phone.util

fun tokenizeExpression(expression: String): MutableList<String> {
    val tokens = mutableListOf<String>()
    var temp = ""

    for (i in expression.indices) {
        val char = expression[i].toString()

        if (char == "-") {
            tokens.add(temp)
            temp = char

            continue
        }

        if (!arrayOf("+", "/", "*", "X").contains(char)) {
            temp = if (char == "%") (temp.toFloat() / 100).toString() else temp + char
        } else {
            tokens.add(temp)
            temp = ""
            tokens.add(char)
        }

        if (i == expression.length - 1) {
            tokens.add(temp)
        }
    }


    return tokens.filter { it != "" }.toMutableList()
}

fun reduceProductAndQuotients(expression: String): MutableList<String> {
    val tokens = tokenizeExpression(expression)

    for ((i, token) in tokens.withIndex()) {
        if (arrayOf("/", "*", "X").contains(token)) {

            val leftOperand = tokens.getOrNull(i - 1)?.toFloat()
            val rightOperand = tokens.getOrNull(i + 1)?.toFloat()

            val equate = if (token == "*" || token == "X") leftOperand!! * rightOperand!! else leftOperand!! / rightOperand!!

            val tokensCopy = tokens.toMutableList()

            tokensCopy[i] = equate.toString()
            tokensCopy.removeAt(i + 1)
            tokensCopy.removeAt(i - 1)

            return reduceProductAndQuotients((tokensCopy.joinToString("")))
        }
    }

    return tokens
}

fun calculate(expression: String): Float {
    return reduceProductAndQuotients(expression).filter { it != "+" }.map { it.toFloat() }
        .reduce { acc, num -> acc + num }
}