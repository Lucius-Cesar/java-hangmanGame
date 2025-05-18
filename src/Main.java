import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        // select a random word in a words txt file
        String wordsFilePath = "words.txt";
        ArrayList <String> words = FileUtils.fileToArrayList(wordsFilePath);
        Random random = new Random();
        int randomWordIndex = random.nextInt(0,words.size());
        String refWord = words.get(randomWordIndex);
        String [] splittedRefWord = refWord.split("");

        // import hangman steps in a text file
        String splittingPattern = "//";
        String hangmanTemplateFilePath = "hangmanTemplate.txt";
        ArrayList <String> hangmanSteps = FileUtils.fileToArrayList(hangmanTemplateFilePath, splittingPattern);

        ArrayList <String> progressStringArray = new ArrayList<>();
        for(int i = 0; i < refWord.length(); i++){
            progressStringArray.add("_");
        }


        int hangmanCurrentStep = -1;

        Scanner scanner = new Scanner(System.in);
        while(hangmanCurrentStep < 6) {
            System.out.print("Enter a letter: ");
            String letter = scanner.nextLine();
            System.out.println();

            //validation
            while(letter.length() > 1){
                System.out.print("you can only enter 1 letter, please retry: ");
                letter = scanner.nextLine().toLowerCase();
                System.out.println();
            }
            //check that user entered a letter
            while(!Character.isLetter(letter.charAt(0))){
                System.out.print("The entered symbol is not a letter, please retry: ");
                letter = scanner.nextLine().toLowerCase();
                System.out.println();

            }
            //it should also support accent (é, ù ...) but I am lazy to implement it


            while(progressStringArray.contains(letter)){
                System.out.print("This letter has already been discovered, please choose another one: ");
                letter = scanner.nextLine().toLowerCase();
                System.out.println();

            }

            //check if letter is in the word to guess
            boolean isLetterInWord = false;
            for(int i = 0; i < refWord.length(); i++){
                if(letter.equalsIgnoreCase(splittedRefWord[i])){
                    progressStringArray.set(i, letter);
                    isLetterInWord = true;

                }
            };

            if(isLetterInWord){
                for(String element:progressStringArray){
                    System.out.print(element);
                }
                System.out.println();

                if(!progressStringArray.contains("_")){
                    System.out.println("You win !");
                    return;
                }
            }
            else{
                hangmanCurrentStep+=1;
                System.out.println(hangmanSteps.get(hangmanCurrentStep));
            }
        }
        System.out.println("You loose");


    }


}
