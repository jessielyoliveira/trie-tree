/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;
import trie.Trie;

/**
 *
 * @author jessiely.oliveira
 */
public class TestInteraction {
    
    public static void main(String[] args) {
        
        Trie tree = new Trie();
        
        Scanner rOption = new Scanner(System.in);
        Scanner rWord = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n-------------");
            System.out.println("1 - insert");
            System.out.println("2 - delete");
            System.out.println("3 - search");
            System.out.println("0 - exit");
            System.out.println("-------------\n");
            
            System.out.print("option: ");
            option = rOption.nextInt();
            String word;
            switch (option) {
                case 0:
                    option = 0;
                    System.out.println("finish program");
                    break;
                case 1:
                    System.out.print("insert the word: ");
                    word = rWord.nextLine();
                    tree.insert(word);
                    break;
                case 2:
                    System.out.print("delete the word: ");
                    word = rWord.nextLine();
                    tree.delete(word);
                break;
                case 3:
                    System.out.print("search the word: ");
                    word = rWord.nextLine();
                    tree.search(word);
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
            
        } while (option != 0);
    }
    
}
