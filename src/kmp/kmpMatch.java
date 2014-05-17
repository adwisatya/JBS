/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kmp;

/**
 *
 * @author adwisatya
 * Taken from Dr. Andrew Davison, "Pattern Matching", WiG Lab, CoE,2006-2007.
 */
public class kmpMatch {
public static int kmpMatch(String text, String pattern) 
  {
    int n = text.length();
    int m = pattern.length();
    int fail[] = computeFail(pattern);
    int i=0;
    int j=0;

    while (i < n) {
      if (pattern.charAt(j) == text.charAt(i)) {
        if (j == m - 1)
          return i - m + 1; // match
        i++;
        j++;
      }
      else if (j > 0)
        j = fail[j-1];
      else
        i++;
    } 
    return -1; // no match
  } // end of kmpMatch()
public static int[] computeFail(String pattern) 
  {
    int fail[] = new int[pattern.length()]; 
    fail[0] = 0;

    int m = pattern.length();
    int j = 0;
    int i = 1;

    while (i < m) {
      if  (pattern.charAt(j) == pattern.charAt(i)) { // j + 1 characters match
        fail[i] = j + 1;
        i++;
        j++;
      }
      else if (j > 0) // j follows a matching prefix
        j = fail[j-1];
      else {     // no match
        fail[i] = 0;
        i++;
      }
    }
    return fail;
    } // end of computeFail()
    
}
