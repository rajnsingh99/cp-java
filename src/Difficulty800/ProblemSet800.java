package Difficulty800;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemSet800 {
    public static void main(String[] args) {
        System.out.println("CodeForce ProblemSet 800 \n");
        bearAndBigBrother(1, 1);
    }

    private static void watermelon(int weight) {
        System.out.println("Weight ---> " + weight);
        if (weight % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("No");
        }
    }

    private static void wayToLongWords(String word) {
        // StringBuilder is not thread safe and faster than StringBuffer
        if (word.length() > 10) {
            String abbreviatedWord = String.valueOf(word.charAt(0)) +
                    (word.length() - 2) +
                    word.charAt(word.length() - 1);
            System.out.println(abbreviatedWord);
        } else {
            System.out.println(word);
        }
    }

    private static void team(List<String> problemList) {
        int solutions = 0;
        for (String problem : problemList) {
            String[] inputs = problem.split(" ");
            int implementedSol = 0;
            for (String input : inputs) {
                implementedSol += Integer.parseInt(input);
            }

            if (implementedSol > 1) {
                ++solutions;
            }
        }

        System.out.println("Solutions --> " + solutions);
    }

    private static void nextRound(int k, int[] scoreArr) {
        int qualifiers = 0;
        for (int j : scoreArr) {
            if (j >= k) {
                ++qualifiers;
            }
        }

        System.out.println("Qualifiers -> " + qualifiers);
    }

    private static void bitPlusPlus(String[] operationArr) {
        int x = 0;
        for (String operation: operationArr) {
            if (operation.contains("++")) {
                ++x;
            } else {
                --x;
            }
        }

        System.out.println("X -> " + x);
    }

    private static void dominoPiling(int m, int n) {
        int volume = m * n;
        if (volume % 2 != 0) {
            --volume;
        }

        System.out.println("Max domino -> " + volume/2);
    }

    private static void beautifulMatrix(int [][] matrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == 1) {
                    int moves = 0;
                    if (Integer.signum(2 - i) < 0) {
                        moves = i - 2;
                    } else {
                        moves = 2 - i;
                    }

                    if (Integer.signum(2 - j) < 0) {
                        moves += j - 2;
                    } else {
                        moves += 2 - j;
                    }

                    System.out.println("Moves -> " + moves);
                }
            }
        }
    }

    private static void petyaAndStrings(String str1, String str2) {
        int str1Weight = 0, str2Weight = 0, output = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length(); i++) {
            str1Weight += Character.getNumericValue(str1.charAt(i));
            str2Weight += Character.getNumericValue(str2.charAt(i));
        }

        if (str1Weight > str2Weight) {
            output = 1;
        } else if (str1Weight < str2Weight) {
            output = -1;
        }
        System.out.println("Output -> " + output);
    }

    private static void wordCapitalization(String word) {
        if (word.charAt(0) != word.toUpperCase().charAt(0)) {
            char[] newWord = new char[word.length()];
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    String tempWord = new String(word.toUpperCase());
                    newWord[0] = tempWord.charAt(0);
                } else {
                    newWord[i] = word.charAt(i);
                }
            }

            System.out.println(newWord);
        } else {
            System.out.println("Default " + word);
        }
    }

   private static void boyOrGirl(String word) {
       Set<Character> uniqueChar = new HashSet<>();
       for (Character c : word.toLowerCase().toCharArray()) {
           uniqueChar.add(c);
       }

       System.out.println((uniqueChar.size() % 2 == 0) ? "CHAT WITH HER!" : "IGNORE HIM!");
   }

   private static void stonesOnTheTable(String input) {
        char currColorCode = input.charAt(0);
        int deletedStone = 0;
        for (int i = 1; i< input.length(); i++) {
            if (currColorCode == input.charAt(i)) {
                ++deletedStone;
            } else {
                currColorCode = input.charAt(i);
            }
        }

        System.out.println(deletedStone);
   }

   private static void bearAndBigBrother(int a, int b) {
        int years = 0;
        while (a <= b) {
            a *= 3;
            b *= 2;
            ++years;
        }

        System.out.println(years);
   }
}
