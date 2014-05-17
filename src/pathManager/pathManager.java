/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pathManager;

/**
 *
 * @author adwisatya
 */
public class pathManager {
    public static String getPath(String pathPart){
        String pathFull = "";
        String [] arrOfPathPart  =    pathPart.split("\\\\");
        for(int i=0;i<arrOfPathPart.length-1;i++){
            if(i>0){
                pathFull    =   pathFull + "\\" + arrOfPathPart[i];
            }else{
                pathFull    =   pathFull + arrOfPathPart[i];
            }
        }
        return pathFull;
    }
    
    public static String getFile(String pathPart){
        String [] arrOfPathPart  =    pathPart.split("\\\\");
        return arrOfPathPart[arrOfPathPart.length-1];
    }
}
