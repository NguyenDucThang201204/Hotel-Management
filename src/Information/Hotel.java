package Information;
import java.io.Serializable;

public class Hotel implements Serializable, Comparable<Hotel>{
        private String hotelId;
        private String hotelName;
        private int hotelRoomAvailable;
        private String hotelAddress;
        private String hotelPhone;
        private int hotelRating;

    public Hotel(String hotelId, String hotelName, int hotelRoomAvailable, String hotelAddress, String hotelPhone, int hotelRating) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRoomAvailable = hotelRoomAvailable;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelRating = hotelRating;
    }
        

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRoomAvailable() {
        return hotelRoomAvailable;
    }

    public void setHotelRoomAvailable(int hotelRoomAvailable) {
        this.hotelRoomAvailable = hotelRoomAvailable;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }
        
    @Override
    public String toString() {
        return String.format("|%9s|%17s|%5d|%20s|%11s|%4d star|\n", hotelId, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating);
    }

    @Override
    public int compareTo(Hotel o) {
        if (this.getHotelName().compareTo(o.getHotelName()) > 0){
            return -1;
        } else if (this.getHotelName().compareTo(o.getHotelName()) < 0) {
            return 1;
        } else {
            return 0;
        }
    }    
    
}
