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
        String [] filePath    =   
        {
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2012\\Desember\\Index.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Desember\\Index.old.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Januari\\Connect.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Januari\\Index.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Januari\\Readme.txt",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Januari\\Trial.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2013\\Juni\\Config.php",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Backup\\2014",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Config",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Css,Bootstrap.css",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Files",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Images",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Images\\Header.jpg",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Images\\Footer.jpg",
            "C:\\Users\\adwisatya\\Documents\\NetBeansProjects\\BackdoorScanner\\src\\root\\Images\\Background.jpg",
        };
        for(int i=0;i<filePath.length;i++){
            checkFile(filePath[i]);
        }
    }
    public static void checkFile(String filePath){
        String [] pattern  =   {"system(","passthru(","exec(","shell_exec("};
        String pathFull = getPath(filePath);
        String fileName = getFile(filePath);  
        if(fileName.contains(".php")){
            String tempString;
            boolean isBackdoor  =    false;
            try{
                FileInputStream fstream = new FileInputStream(filePath);
                BufferedReader    tempLine    =    new BufferedReader(new InputStreamReader(fstream));
                while(((tempString = tempLine.readLine()) != null) && !isBackdoor){
                    for(int i=0;i<pattern.length;i++){
                           isBackdoor  =   isBackdoor || (kmpMatch(tempString,pattern[i]) != -1);
                    }
                }     
            }catch(Exception e){
                // do nothing
            }    
            if(isBackdoor){
                System.out.println("Directory: " + pathFull);
                System.out.println(fileName + " is a backdoor");
            }else{
                System.out.println("Directory: " + pathFull);
                System.out.println(fileName + " is not a backdoor");  
            }
        }else{
                System.out.println("Directory: " + pathFull);
                System.out.println(fileName + " is not php file"); 
        }
    }
}
