package Management;

import Information.Hotel;
import utilities.CheckUpdateMethod;
import FileManagement.FileImportExport;
import utilities.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelList implements IHotelList{
        private ArrayList <Hotel> arrHotel;
        private FileImportExport fm;
        private CheckUpdateMethod cm;
        
    //constructors
    public HotelList() {
        arrHotel = new ArrayList<>();
        cm = new CheckUpdateMethod();
        fm = new FileImportExport();
      /*  try {
            fm.loadDataFromFile(arrHotel, "Hotel.dat");
            
        } catch (Exception e) {
            System.out.println("Empty List");
        }*/
      if(arrHotel.size()<4){
                System.err.println("Please press number 1 to add Hotel until there are 4 hotels at least");
            }
    }
    
    //Menu 1
    @Override
    public void loadData() {
           try {
            fm.loadDataFromFile(arrHotel, "Hotel.dat");
            while(arrHotel.size()<4){
                System.err.println("Please add Hotel until there are 4 hotels at least");
                this.addHotel();
            }
        } catch (Exception e) {
            System.out.println("Empty List");
        }
    }
    
    
    @Override
    public void addHotel() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;
        int choice = 1;
        while (choice==1) {
            hotelId = Utils.getStringreg("Enter hotel's ID (Hxx): ","H\\d{2}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
            for (Hotel hotel : arrHotel) {
                if(hotel.getHotelId().equals(hotelId)){
                    System.out.println("ID hotel exists");
                    return;
                }
            }
            hotelName = Utils.getStringreg("Enter hotel's name: ", "^[a-zA-Z\\s]+","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
            hotelRoomAvailable = Utils.getInt("Enter the number of available rooms: ", 0, 10000);
            hotelAddress = Utils.getStringreg("Enter hotel's address: ","^[a-zA-Z0-9/,\\s]+","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
            hotelPhone = Utils.getStringreg("Enter hotel's phone number(0xxxxxxxx): ", "0\\d{9}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
            hotelRating = Utils.getInt("Enter hotel's rating(0-6): ", 0, 6);
            Hotel e = new Hotel(hotelId, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating);
            arrHotel.add(e);
            System.out.println("Successful");
            choice = Utils.inputYN("Do you want to continue add Hotel(Y/N): ");
        }
    }
    
    //Menu 2
      @Override
     public void checkExistsHotel() {
        int choice=1;
        while(choice==1){
        String id = Utils.getStringreg("Enter id of hotel you want to check (Hxx): ","H\\d{2}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
        Hotel hotelId = cm.searchHotelByID(arrHotel, id.trim());
        if (hotelId != null) {
            System.out.println("Exist hotel");
            UI(hotelId);
        } else {
            System.err.println("No Hotel Found!");
        }
        choice = Utils.inputYN("Do you want to continue check exists Hotel (Y/N): ");
        }
    }
     
     //Menu 3
      @Override
     public void updateHotelInformation() {
        ArrayList<Hotel> arrTemp = new ArrayList<>();
        if(arrHotel.isEmpty()){
             fm.loadDataFromFile(arrHotel, "Hotel.dat");
         }
        String id = Utils.getStringreg("Enter hotel's ID to update information (Hxx): ","H\\d{2}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
        fm.loadDataFromFile(arrTemp, "Hotel.dat");
        Hotel hotel = cm.searchHotelByID(arrTemp, id.trim());
        Hotel hotel2 = cm.searchHotelByID(arrHotel, id.trim());
        if (hotel != null) {
            System.out.println("Exist hotel. Here is the hotel you search for: ");
            UI(hotel);
            cm.updateInforHotel(hotel);
            System.out.println("Here is hotel's information after update: ");
            UI(hotel);
            arrHotel.set(arrHotel.indexOf(hotel2), hotel);
     
        } else {
            System.err.println("Hotel does not exist");
        }
    }
     
     //Menu 4
      @Override
     public void deleteHotel() {
         ArrayList<Hotel> arrTemp = new ArrayList<>();
         fm.loadDataFromFile(arrTemp, "Hotel.dat");
         if(arrHotel.isEmpty()){
             fm.loadDataFromFile(arrHotel, "Hotel.dat");
         }
        String id = Utils.getStringreg("Enter hotel's ID you want to delete (Hxx): ","H\\d{2}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
        Hotel hotel = cm.searchHotelByID(arrTemp, id.trim());
        Hotel hotel2 = cm.searchHotelByID(arrHotel, id.trim());
        int choice = 1;
        if (hotel != null) {
            System.out.println("Exist Hotel. Here is the hotel you search for: ");
            UI(hotel);
            choice = Utils.inputYN("Do you ready want to delete this hotel(Y/N): ");
            if (choice==1) {
                arrHotel.remove(hotel2);
                System.out.println("The hotel has been deleted from the list successfully!");
            }
        } else {
            System.err.println("Not found!");
        } 
    }
    
     //Menu 5
      @Override
    public void searchHotel() {
        int choice;
        ArrayList<Hotel> arrTemp = new ArrayList<>();
        ArrayList<Hotel> arrResult1 = new ArrayList<>();
        ArrayList<Hotel> arrResult2 = new ArrayList<>();
        fm.loadDataFromFile(arrTemp, "Hotel.dat");
        
        do {
            boolean check = false;
        System.out.println("1. Search by Hotel_id");
        System.out.println("2. Search by Hotel_address");
        System.out.println("3. Exit");
        choice = Utils.getInt("Enter a number from 1 to 3: ", 1, 3);
            switch (choice) {
                case 1:
                    String id = Utils.getStringreg("Enter id of hotel you want to check (Hxx): ","H\\d{2}","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");
                    for (Hotel hotel : arrTemp) {
                        if (hotel.getHotelId().contains(id)) {
                            arrResult1.add(hotel);
                            check = true;
                        }
                    }
                    if (check==false) {
                        System.err.println("Can't found id: " + id);
                    }else{
                        for(Hotel hotel: arrResult1){
                          UI(hotel);  
                        }
                    }
                    break;
                case 2:
                    String address = Utils.getStringreg("Enter hotel's address: ","^[a-zA-Z0-9/\\s]+","DO NOT LET THIS BOX EMPTY","INPUT MUST BE THE SAME AS PATTERN");

                    for (Hotel hotel : arrTemp) {
                        if (hotel.getHotelAddress().contains(address)) {
                            arrResult2.add(hotel);
                            check = true;
                        }
                    }
                    if (check==false) {
                        System.err.println("Can't found address: " + address);
                    }else{
                        Collections.sort(arrResult2,new Comparator<Hotel>(){
                            @Override
                            public int compare(Hotel o1, Hotel o2) {
                                if (o1.getHotelRoomAvailable()-o2.getHotelRoomAvailable() > 0){
                                    return -1;
                                    } else if (o1.getHotelRoomAvailable()-o2.getHotelRoomAvailable() < 0) {
                                             return 1;
                                    } else {
                                        return 0;
                                            }
                            } 
                        });
                        for(Hotel hotel: arrResult2){
                          UI(hotel);  
                        }
                    }
                    break;

                default:
                    System.out.println("Out to main menu");
            }
        } while (!(choice < 1 || choice > 2));
    }
    
    //Menu 6
     @Override
    public void displayHotel() {
        ArrayList <Hotel> arrHotelFile = new ArrayList<>(); 
        fm.loadDataFromFile(arrHotelFile,"Hotel.dat");
        if (arrHotelFile.isEmpty()) {
            System.err.println("Empty list");
        }else{
        System.out.printf("%-9s|%-17s|%-25s|%-30s|%-11s|%-86s|\n", "Hotel_id", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
        Collections.sort(arrHotelFile);
        for (Hotel hotel : arrHotelFile) {
            UI(hotel);
        }
        }
    }
    
    //User interface of the table
    public void UI(Hotel hotel) {
    System.out.println("_______________________________________________________________________________________________________________");
    System.out.printf("%-9s|%-17s|%25s|%-30s|%11s|%7s star|\n",hotel.getHotelId(), hotel.getHotelName(), hotel.getHotelRoomAvailable(), hotel.getHotelAddress(), hotel.getHotelPhone(), hotel.getHotelRating()); 
 
        System.out.println("____________________________________________________________________________________________________________");
}
    
    //Menu 7
     @Override
    public void saveDataFile(){
        fm.saveDataToFile(arrHotel, "Hotel.dat","File Save successfully!","Fail");
        arrHotel.clear();
    }
    
    //Menu 8
    @Override
    public boolean checkOut(int count){
        if(!arrHotel.isEmpty()&&count!=0){
            int choice1;
            choice1=Utils.inputYN("Do you want to save data to file(Y/N): ");
            if(choice1==1){
                fm.saveDataToFile(arrHotel, "Hotel.dat","File Save successfully!","Fail");
                return true;
            }     
        }
        return true;
    }

    
}
