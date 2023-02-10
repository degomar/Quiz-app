package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question>{

        var questionList = ArrayList<Question>()

        val questionOne = Question(1,R.drawable.ic_flag_of_argentina,
            "Qual o país que esta bandeira pertence",
            "Guatemala", "Bolívia",
            "Brasil","Argentina", 4)

        val questionTwo = Question(1,R.drawable.ic_flag_of_belgium,
            "Qual o país que esta bandeira pertence",
            "Senegal", "Belgica",
            "Irlanda","Japão", 2)

        val questionThree = Question(1,R.drawable.ic_flag_of_brazil,
            "Qual o país que esta bandeira pertence",
            "Espanha", "Bolívia",
            "Camarões","Brasil", 4)

        val questionFour = Question(1,R.drawable.ic_flag_of_australia,
            "Qual o país que esta bandeira pertence",
            "Australia", "Suiça",
            "Senegal","Chile", 1)

        val questionFive = Question(1,R.drawable.ic_flag_of_denmark,
            "Qual o país que esta bandeira pertence",
            "México", "Sudão",
            "Dinamarca","Jordania", 3)

        val questionSix = Question(1,R.drawable.ic_flag_of_fiji,
            "Qual o país que esta bandeira pertence",
            "Fiji", "Brasil",
            "Reino Unido","Canáda", 1)

        val questionSeven = Question(1,R.drawable.ic_flag_of_germany,
            "Qual o país que esta bandeira pertence",
            "Russia", "Alemanha",
            "Estados Unidos","Bélgica", 2)

        val questionEight = Question(1,R.drawable.ic_flag_of_india,
            "Qual o país que esta bandeira pertence",
            "Turquia", "Moçambique",
            "India","Israel", 3)

        val questionNine = Question(1,R.drawable.ic_flag_of_kuwait,
            "Qual o país que esta bandeira pertence",
            "Fiji", "Russia",
            "Sudão","Kuwait", 4)

        questionList.add(questionOne)
        questionList.add(questionTwo)
        questionList.add(questionThree)
        questionList.add(questionFour)
        questionList.add(questionFive)
        questionList.add(questionSix)
        questionList.add(questionSeven)
        questionList.add(questionEight)
        questionList.add(questionNine)

        return questionList
    }

}