package Management;

public interface IHotelList {
    public void loadData();
    public void addHotel();
    public void checkExistsHotel();
    public void updateHotelInformation();
    public void deleteHotel(); 
    public void searchHotel();
    public void displayHotel();
    public void saveDataFile();
    public boolean checkOut(int count);
}
