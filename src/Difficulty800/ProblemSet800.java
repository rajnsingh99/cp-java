package Difficulty800;

public class ProblemSet800 {
    public static void main(String [] args) {
        System.out.println("CodeForce ProblemSet 800 \n");


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


}
