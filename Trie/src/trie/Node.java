/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

// https://www.geeksforgeeks.org/trie-insert-and-search/

/**
 *
 * @author jessielyoliveira
 */
public class Node {
    
    // 150 por causa da tabela ascII
    static final int ALPHABET = 150;
    
    Node[] next = new Node[ALPHABET];
    boolean terminal;
    
    Node() {
        terminal = false;
        for(int i = 0; i < ALPHABET; i++) {
            next[i] = null;
        }
    }   
         
}
