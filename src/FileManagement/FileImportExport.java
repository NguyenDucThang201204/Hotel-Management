package FileManagement;

import java.io.EOFException;
import Information.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileImportExport {
        public boolean saveDataToFile(ArrayList<Hotel> list, String FName, String success, String error) {
        try {
            File f = new File(FName);
            FileOutputStream os = new FileOutputStream(f);
            ObjectOutputStream output = new ObjectOutputStream(os);
            for (Hotel h : list) {
                output.writeObject(h);
            }
            os.close();
            output.close();
            System.out.println(success);
            return true; 
        } catch (Exception e) {
            System.err.println(error+": "+e);
            return false;
        }
    }
   
    
    public boolean loadDataFromFile(ArrayList<Hotel> list, String FName) {
        try {
            File f = new File(FName);
            if (!f.exists()) {
                return false;
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream is = new ObjectInputStream(fis);
            if (f.length() == 0) {
                System.err.println("File is empty");
            }
            
            boolean flag=true;
            while ( flag) {
                try{
                    Hotel h = (Hotel) is.readObject();
                    list.add(h);
                }catch(EOFException e){
                    flag=false;
                    break;
            }
            }
            
            fis.close();
            is.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } 
        return true;
    }
    
        
}
