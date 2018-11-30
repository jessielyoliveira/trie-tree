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
        
        if(searchHelp(word)) {
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
            System.out.println("word inserted -> " + word);
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
        if(!searchHelp(word)) {
            System.out.println("word does not exist -> " + word);
        } else {
            delete(root, word, 0);
            System.out.println("word deleted -> " + word);
        }
    }
    
    
    private boolean searchHelp(String word) {
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
    
    public void search(String word) {
        if(searchHelp(word)) {
            System.out.println("word found -> " + word);
        } else {
            System.out.println("word not found -> " + word);
        }
    }
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Trie tree = new Trie();
        
        tree.insert("alto");
        tree.insert("alteza");
        tree.insert("amor");
        tree.insert("amorteceu");
        tree.insert("cola");
        tree.insert("galinha");
        tree.insert("galo");
        
        tree.search("meta");
        tree.search("amor");
        tree.search("alteza");
        
        tree.delete("arroz");
        tree.delete("amor");
        tree.delete("cola");
        tree.search("amorteceu");
        
        
        

    }
        
}
    
