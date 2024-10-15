package Question_Management_System;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class QuestionHub {
    private HashMap<String, String[]> questionsAndOptions;
    private HashMap<String, Character> correctAnswers;
    private List<String> listOfIncorrectAnswers;
    private int score;


    public QuestionHub() {
        questionsAndOptions = new HashMap<>();
        correctAnswers = new HashMap<>();
        listOfIncorrectAnswers = new ArrayList<>();

        questionsAndOptions.put("How many primitive data types do we have in Java?",
                new String[]{"a: 5", "b: 6", "c: 10", "d: 8"});
        correctAnswers.put("How many primitive data types do we have in Java?", 'd');

        questionsAndOptions.put("What is the default value of an int in Java?",
                new String[]{"a: 1", "b: 0", "c: -1", "d: null"});
        correctAnswers.put("What is the default value of an int in Java?", 'b');

        questionsAndOptions.put("What is the default value of a boolean in Java?",
                new String[]{"a: true", "b: false", "c: 1", "d: null"});
        correctAnswers.put("What is the default value of a boolean in Java?", 'b');

        questionsAndOptions.put("What is the default value of a char in Java?",
                new String[]{"a: '0'", "b: '\u0000'", "c: ' ' (space)", "d: null"});
        correctAnswers.put("What is the default value of a char in Java?", 'b');


        startQuiz();
        displayScore();
        displayIncorrectAnswers();
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<String, String[]> entry : questionsAndOptions.entrySet()) {
            String question = entry.getKey();
            String[] options = entry.getValue();

            displayQuestion(question, options);
            char answer;
            while (true) {
                System.out.print("Enter your answer (a/b/c/d): ");
                answer = scanner.next().charAt(0);

                if (isValidAnswer(answer)) {
                    break;
                } else {
                    System.out.println("Invalid option. Please enter a valid answer (a, b, c, or d).");
                }
            }
            if (answer == correctAnswers.get(question)) {
                score++;
            } else {
                listOfIncorrectAnswers.add(question);
            }
            clearConsole();
        }

//        displayScore();
//        displayIncorrectAnswers();
    }

    private void displayQuestion(String question, String[] options) {
        System.out.println("Question: " + question);
        for (String option : options) {
            System.out.println(option);
        }
    }

    private void displayScore() {
        System.out.println("You got " + score + " out of " + questionsAndOptions.size() + " correct.");
    }

    private void displayIncorrectAnswers() {
        if (!listOfIncorrectAnswers.isEmpty()) {
            System.out.println("Here are the correct answers for the questions you got wrong:");
            for (String question : listOfIncorrectAnswers) {
                System.out.println("Question: " + question);
                String[] options = questionsAndOptions.get(question);
                for (String option : options) {
                    System.out.println(option);
                }
                System.out.println("Correct answer: " + correctAnswers.get(question));
            }
        } else {
            System.out.println("Awesome! You got all the questions correct!");
        }




    }
    private boolean isValidAnswer(char answer) {
        return answer == 'a' || answer == 'b' || answer == 'c' || answer == 'd';
    }
    private void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}

