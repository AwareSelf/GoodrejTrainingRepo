package fileio;

import java.io.IOException;  
import java.io.RandomAccessFile;  
  

/*
The myFile.TXT contains text "This class is used for reading and writing to random access file."

after running the program it will contains

This class is used for reading I love my country and my peoplele.
 */

public class RandomAccessFileExample {  
    static final String FILEPATH ="src/fileio/MyFile.txt";  
    public static void main(String[] args) {  
        try {  
            System.out.println(new String(readFromFile(FILEPATH, 0, 18)));  
            writeToFile(FILEPATH, "I love my country and my people", 31);  
            appendToFile(FILEPATH,"My name is Namrata.");
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    private static byte[] readFromFile(String filePath, int position, int size)  
            throws IOException {  
        RandomAccessFile file = new RandomAccessFile(filePath, "r");  
        file.seek(position);  
        System.out.println("filepointer location:"+file.getFilePointer());
        byte[] bytes = new byte[size];  
        file.read(bytes);  
        file.close();  
        return bytes;  
    }  
    private static void writeToFile(String filePath, String data, int position)  
            throws IOException {  
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");  
        
        //file.seek(file.length()); //to append to end of file, ensure that file pointer is at the end of file
        file.seek(position);  
        file.write(data.getBytes());  
        file.close();  
    }  
    private static void appendToFile(String filePath, String data)  
            throws IOException {  
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");  
        
        file.seek(file.length()); //to append to end of file, ensure that file pointer is at the end of file
        System.out.println("filepointer location:"+file.getFilePointer());
        file.write(data.getBytes());  
        System.out.println("filepointer location:"+file.getFilePointer());
        file.close();  
    }  
    
}  