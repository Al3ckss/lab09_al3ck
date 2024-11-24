package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    //The default file is "output.txt" in the home folder. The complete path is firstfile.

    private final String firstfilename = "output.txt";
    private File currentFile = new File(transformToPath(firstfilename));
    
    public Controller(){
    }

    String transformToPath(String filename){
        return System.getProperty("user.home") + System.getProperty("file.separator") + filename;
    }

    void setFileAsCurrent(File file){
        this.currentFile = file;
    }

    File getFile(){
        return this.currentFile;
    }

    String getPath(){
        return currentFile.getAbsolutePath(); 
    }

    void saveStringToFile(String string) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile, true))) {
        writer.write(string);
        writer.newLine();
        }
    }


}
