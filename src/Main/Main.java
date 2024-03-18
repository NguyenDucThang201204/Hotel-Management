package Main;

import Management.HotelList;
import utilities.Utils;

public class Main {

    public static void main(String args[]) {

        boolean flag = true;
        int count = 0;
        HotelList hl = new HotelList();
        do {
            System.out.println("MENU");
            System.out.println("1) Load data to file from program");
            System.out.println("2) Adding new Hotel");
            System.out.println("3) Checking exists Hotel");
            System.out.println("4) Updating Hotel information");
            System.out.println("5) Deleting Hotel");
            System.out.println("6) Searching Hotel");
            System.out.println("7) Displaying a hotel list");
            System.out.println("8) Save to file");
            System.out.println("9) Others Quit");
            int choice = Utils.getInt("Enter a number from 1 to 8: ", 1, 8);
            switch (choice) {
                case 1:
                    hl.loadData();
                    break;
                case 2: 
                        hl.addHotel();
                        count++;
                        break;
                case 3:
                    hl.checkExistsHotel();
                    break;
                case 4:
                    hl.updateHotelInformation();
                    count++;
                    break;
                case 5:
                    hl.deleteHotel();
                    count++;
                    break;
                case 6:
                    hl.searchHotel();
                    break;
                case 7:
                    hl.displayHotel();
                    break;
                case 8:
                    hl.saveDataFile();
                    break;
                case 9:
                    if (hl.checkOut(count)) {
                        System.out.println("Thanks for using");
                        flag = false;
                        break;
                    }
            }
        } while (flag);

    }

}
