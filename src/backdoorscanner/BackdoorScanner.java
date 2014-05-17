/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backdoorscanner;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static kmp.kmpMatch.kmpMatch;
import static pathManager.pathManager.*;
/**
 *
 * @author adwisatya
 */
public class BackdoorScanner {
    public static void main(String[] args) {
        // TODO code application logic here
        String pattern  =   "system(";
        String filePath    =   "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\backdoorscanner\\backdoor.php";
        String pathFull = getPath(filePath);
        String fileName = getFile(filePath);  
        String tempString;
        boolean isBackdoor  =    false;
        try{
            FileInputStream fstream = new FileInputStream(filePath);
            BufferedReader    tempLine    =    new BufferedReader(new InputStreamReader(fstream));
                  
            while(((tempString = tempLine.readLine()) != null) && !isBackdoor){
                if(kmpMatch(tempString,pattern) != -1){
                    isBackdoor  =   true;
                }
            }     
            if(isBackdoor){
                System.out.println("Directory: " + pathFull);
                System.out.println(fileName + " is backdoor");
            }
        }catch(Exception e){
            System.out.println("Terdapat kesalahan pembacaan");
        }
    }

}
