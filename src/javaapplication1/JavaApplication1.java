/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
import java.lang.Object;
import java.util.HashMap;

/**
 *
 * @author 2112076
 */
public class JavaApplication1 {
    private static HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    /**
     * @param a
     * @param b
     */
    @Override
    public boolean equals(Object t){
        if (this == t){
            return true;
        } else{
            return false;
        }
    }   
    public static boolean isAnAnagram(String a, String b){
        boolean val=true;
        if (a.length()!=b.length()){
            val=false;
        } else{
            for (int i=0 ; i<a.length(); i++){
                if (charMap.isEmpty()){
                    charMap.put(a.charAt(i),1);
                } else{
                    if(charMap.containsKey(a.charAt(i))){
                        int valor=charMap.get(a.charAt(i));
                        charMap.replace(a.charAt(i),valor+1);
                    } else{
                        charMap.put(a.charAt(i),1);
                    }
                }
            }
            for (int i=0 ; i<b.length(); i++){
               if(!charMap.containsKey(b.charAt(i))){
                   val=false;
                   return false;
               } else{
                   int valor=charMap.get(b.charAt(i));
                   charMap.replace(b.charAt(i),valor-1);
               }
            }
            for (int i=0;i<a.length(); i++){
                if(charMap.get(b.charAt(i))!=0){
                    return false;
                }
            }
        }
        return val;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("input first string:");
        String a = sc.nextLine(); 
        System.out.println("input second string:");
        String b = sc.nextLine();
        boolean res=isAnAnagram(a,b);
        System.out.println(res);
    }
    
}
