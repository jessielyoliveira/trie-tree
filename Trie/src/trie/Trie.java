/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jessielyoliveira
 */
public class Trie {
   
    private final Node root = new Node();
    
    public void insert(String word) {
        
        if(search(word)) {
            System.out.println("already inserted");
        } else {
            int character, index;
            Node pNode = root;

            for (character = 0; character < word.length(); character++) {
                index = word.charAt(character);

                if (pNode.next[index] == null) {
                    pNode.next[index] = new Node();
                }
                pNode = pNode.next[index];
            }
            pNode.terminal = true;
            System.out.println("word inserted");
        }
    }
    
    private boolean hasNextNode(Node pNode) {
        for (Node nextNode : pNode.next) {
            if (nextNode != null) {
                return true;
            } 
        }
        return false;
    }
    
    
    boolean delete(Node pNode, String word, int index) {
        boolean deleteNode = false;

        if(index == word.length()) {
            
            if(hasNextNode(pNode)) {
                pNode.terminal = false;
                deleteNode = false;
            } else {
                pNode = null;
                deleteNode = true;
            }
            
        } else {
            Node nextNode = pNode.next[word.charAt(index)];
            boolean nextNodeDeleted = delete(nextNode, word, index + 1);
            
            if(nextNodeDeleted) {
                pNode.next[word.charAt(index)] = null;
                if(pNode.terminal) {
                    deleteNode = false;
                } else if(hasNextNode(pNode)) {
                    deleteNode = false;
                } else {
                    pNode = null;
                    deleteNode = true;
                }
            } else {
                deleteNode = false;
            }
        }
        
        return deleteNode;          
    }
    
    public void delete(String word) {
        if(!search(word)) {
            System.out.println("word does not exist");
        } else {
            delete(root, word, 0);
            System.out.println("word deleted");
        }
    }
    
    
    public boolean search(String word) {
        int character, index;
        Node pNode = root;
        
        for(character = 0; character < word.length(); character++) {
            index = word.charAt(character);
            if(pNode.next[index] == null) {
                return false;
            }
            pNode = pNode.next[index];
        }
        return ((pNode != null) && pNode.terminal);
    }
    
 
    /**
     * @param args the command line arguments
     */
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
                    if (tree.search(word)) {
                        System.out.println("word found");
                    } else {
                        System.out.println("word not found");
                    }
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
            
        } while (option != 0);

    }
        
}
    
