package utilities;

import Information.Hotel;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckUpdateMethod {
    Scanner sc = new Scanner(System.in);

         public Hotel searchHotelByID(ArrayList<Hotel> arr, String id){
        for (Hotel hotel : arr) {
            if(id.equals(hotel.getHotelId())){
                return hotel;
            }
        }
        return null;
    }
         
        public String getStringregIsEmpty(String welcome,String pattern,String msgreg, Hotel hotel) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            
            System.out.print(welcome);
            result = sc.nextLine();
            // Input nothing
            if(result.trim().isEmpty()){
                return result;
            }
            //or input correct like the pattern
           else if(!result.matches(pattern)){
                System.out.println(msgreg);
            } 
            else {
                check = false;
            }
        } while (check);
        return result;
    }
         
         public void updateInforHotel(Hotel hotel){
             String name, roomAvailable, addRess,phone,rating;
             
             name=this.getStringregIsEmpty("Enter name to update: ", "^[a-zA-Z\\s]+", "input must be the same as pattern",hotel);
             if(name.trim().isEmpty()){
                 hotel.setHotelName(hotel.getHotelName());
             }else{
                 hotel.setHotelName(name);
             }
             
             
             roomAvailable=this.getStringregIsEmpty("Enter hotel's room available to update: ", "^[0-9]+", "input must be the same as pattern",hotel);
             if(roomAvailable.trim().isEmpty()){
                 hotel.setHotelRoomAvailable(hotel.getHotelRoomAvailable());
             }else{
                hotel.setHotelRoomAvailable(Integer.parseInt(roomAvailable));
             }
             
             addRess = this.getStringregIsEmpty("Enter hotel's address you want to update: ", "^[a-zA-Z0-9/,\\s]+", "input must be the same as pattern",hotel);
             if(addRess.trim().isEmpty()){
                 hotel.setHotelAddress(hotel.getHotelAddress());
             }else{
                 hotel.setHotelAddress(addRess);
             }
                     
             phone = this.getStringregIsEmpty("Enter hotel's phone you want to update: ", "^[0\\d{9}]+", "input must be the same as pattern",hotel);
             if(phone.trim().isEmpty()){
                 hotel.setHotelPhone(hotel.getHotelPhone());
             }else{
                 hotel.setHotelPhone(phone);
             }
             
             rating=this.getStringregIsEmpty("Enter hotel's rating to update (1-6): ", "^[1-6]", "input must be the same as pattern",hotel);
             if(rating.trim().isEmpty()){
                 hotel.setHotelRating(hotel.getHotelRating());
             }else{
                hotel.setHotelRating(Integer.parseInt(rating));
             }
             
             
         } 
         
         
         
}
