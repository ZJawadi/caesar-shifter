import java.io.*;
import java.util.*;

/*
 * This program encrypts and decrypts text provided by the user based on an integer key
 *
 * Author: Zorah
 * Prompt: Caesar Shifter
 * Date Created: September 30, 2019
 * Last Modified: November 6, 2019
 * Assumptions: that alphabet.txt has proper input (specified in the instructions)
*/

class Main {
  public static void main(String[] args) throws IOException{

    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     
    //Opening all necessary files, scanners, filewriters and printwriters
    File alphabetFile = new File("alphabet.txt"); 
    Scanner alphabetScanner = new Scanner(alphabetFile);
    FileWriter encryptedfwriter = new FileWriter("encrypted.txt", true);
    PrintWriter encryptedFile = new PrintWriter(encryptedfwriter);
    FileWriter decryptedfwriter = new FileWriter("decrypted.txt", true);
    PrintWriter decryptedFile = new PrintWriter(decryptedfwriter);
    File normalFile = new File("originalText.txt");
    Scanner normalScanner = new Scanner(normalFile);  

    String word=alphabetScanner.next();
    word=word.toUpperCase();

    //The swtich structure menu
    System.out.print("\nWelcome to Caesar Shifter! This program will encrypt or decrypt text based on an integer YOU input! \nPlease choose one of the following options: \n\tA) Encrypt text\n\tB) Decrypt text\nYour choice: ");
    char text = br.readLine().charAt(0);

    //Beginning of switch
    switch(text){
      case 'a':
      case 'A':

        //This is the encryption section

        //output lines for formatting
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\nPlease input the text you would like to be encrypted into originalText.txt. \nYou can also change the alphabet you are using in alphabet.txt \n(Please don't use any spaces and keep all the letter on one line. Ex. abcdefghijklmnopqrstuvwxyz)");

        //Stores the integer key the user inputs into the int "cypherMover"
        System.out.print("\nInput an integer as the encryption key: ");
        int cypherMover=Integer.parseInt(br.readLine());

        //a do-while loop that will loop so long as there is a next token in originalText.txt
        do {
        
          //two alphabet arraylists contain the same data from alphabet.txt
          List<String> alphabetArray = new ArrayList<String>();
          List<String> alphabetArray2 = new ArrayList<String>();
          for (int i = 0;i<word.length();i++) {
            alphabetArray.add(word.substring(i, i+1));
          }
          for (int i = 0;i<word.length();i++) {
            alphabetArray2.add(word.substring(i, i+1));
          }

          //encryptArray contains information from originalText.txt
          String normalText = normalScanner.next(); 
          normalText = normalText.toUpperCase();
          List<String> encryptArray = new ArrayList<String>();
          for (int i=0;i<normalText.length();i++) {
            encryptArray.add(normalText.substring(i, i+1));
          }

          //alphabetArray2 is rearranged based on if cypherMover is a positive number
          if(cypherMover>=0){
            for(int i=0;i<cypherMover;i++){
              alphabetArray2.add(alphabetArray2.size(), alphabetArray2.get(0));
              alphabetArray2.remove(0);
            } 
          }
          //alphabetArray2 is rearranged based on if cypherMover is a negative number
          else if(cypherMover<0){
            for(int i=(cypherMover);i<0;i++){
              alphabetArray2.add(0, alphabetArray2.get(alphabetArray2.size()-1));
              alphabetArray2.remove(alphabetArray.size());
            } 
          }

          String bruh = word.substring(0, alphabetArray.size());

          //This for loop will compare the element of encryptArray to every single element of alphabetArray until they are equal, and then it will output the encrypted letter in encrypted.txt
          for(int x=0;x<encryptArray.size();x++) {
            for (int y=0;y<alphabetArray.size();y++) {
              if(encryptArray.get(x).equals(alphabetArray.get(y))){
                encryptedFile.print(alphabetArray2.get(y)); 
              } 
            }
            //this if statement handles non-letter
            if(bruh.contains(encryptArray.get(x))==false)
              encryptedFile.print(encryptArray.get(x));
 
          }//end of for loop
          encryptedFile.print(" ");
        
        }while (normalScanner.hasNext()); // end of do-while loop

      //output for formatting
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.print("\nThe encrypted text will be written in the file encypted.txt.");

      //end of encryption section
      break;

      case 'b':
      case 'B':
        //This is the decryption section

        //output for formatting
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\nPlease input the text you would like to be decrypted into originalText.txt. \nYou can also change the alphabet you are using in alphabet.txt \n(Please don't use any spaces and keep all the letter on one line. Ex. abcdefghijklmnopqrstuvwxyz)");

        //Stores the integer key the user inputs into the int "cypherMover"
        System.out.print("\nInput an integer as the decryption key: ");
        cypherMover=Integer.parseInt(br.readLine());

        //a do-while loop that will loop so long as there is a next token in originalText.txt
        do {
          
          //two alphabet arraylists contain the same data from alphabet.txt
          List<String> alphabetArray = new ArrayList<String>();
          List<String> alphabetArray2 = new ArrayList<String>();
          for (int i = 0;i<word.length();i++) {
            alphabetArray.add(word.substring(i, i+1));
          }
          for (int i = 0;i<word.length();i++) {
            alphabetArray2.add(word.substring(i, i+1));
          }

          //encryptArray contains information from originalText.txt
          String normalText = normalScanner.next(); 
          normalText = normalText.toUpperCase();
          List<String> decryptArray = new ArrayList<String>();
          for (int i=0;i<normalText.length();i++) {
            decryptArray.add(normalText.substring(i, i+1));
          }

          //alphabetArray2 is rearranged based on if cypherMover is a positive number
          if(cypherMover>=0){
            for(int i=0;i<cypherMover;i++){
              alphabetArray2.add(0, alphabetArray2.get(alphabetArray2.size()-1));
              alphabetArray2.remove(alphabetArray2.size()-1);
            } 
          }
          //alphabetArray2 is rearranged based on if cypherMover is a negative number
          else if(cypherMover<0){
            for(int i=cypherMover;i<0;i++){
              alphabetArray2.add(alphabetArray2.size(), alphabetArray2.get(0));
              alphabetArray2.remove(0);
            } 
          }

          String bruh = word.substring(0, alphabetArray.size());

          //This for loop will compare the element of encryptArray to every single element of alphabetArray until they are equal, and then it will output the encrypted letter in encrypted.txt
          for(int x=0;x<decryptArray.size();x++) {
            for (int y=0;y<alphabetArray.size();y++) {
              if(decryptArray.get(x).equals(alphabetArray.get(y)))
                decryptedFile.print(alphabetArray2.get(y));     
            }
            //these if statements handle non-letter input
            if(bruh.contains(decryptArray.get(x))==false)
              decryptedFile.print(decryptArray.get(x));
          }
          decryptedFile.print(" ");
        
        }while (normalScanner.hasNext());
        //output for formatting
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\nThe decrypted text will be written in the file decypted.txt.");
      break;
      default:
        System.out.println("Invalid input.");
    }//end of switch

    //Close all files 
    encryptedFile.close();
    decryptedFile.close();
  }//end main
}//end class Main