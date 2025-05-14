
package com.flip.gmzhotel;


public class RoomReservation extends Reservation {
    
    private static double numberOfRoomReservation = 0;
    private final double regularRoomCost = 200, seaViewRoomCost =300 , breakfatCost = 25.5 ;
    private boolean breakfast;
    private double roomtotalCost ;
    private char roomType;
    
    
    public RoomReservation (String reservationName,String reservationDate,int reservationPeriod, boolean breakfast, char roomType)
    {
        super(reservationName,reservationDate,reservationPeriod);
        this.breakfast = breakfast;
        this.roomType = roomType;
        numberOfRoomReservation += 1; 
    }
    
    
    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public char getRoomType() {
        return roomType;
    }

    public void setRoomType(char roomType) {
        this.roomType = roomType;
    }

    public double getBreakfatCost() {
        return breakfatCost;
    }
 

    public static double getNumberOfReservation() {
        return numberOfRoomReservation;
    }

  
    public void calculateTotalCost()
    {
        if (roomType == 's' || roomType == 'S')
        {
            if(breakfast == true)
            {
            roomtotalCost = (seaViewRoomCost + breakfatCost)* super.getReservationPeriod();
        super.setTotalCost(roomtotalCost);
            }
            else 
            {
            roomtotalCost = seaViewRoomCost* super.getReservationPeriod();
            super.setTotalCost(roomtotalCost);
                    
            }

        }
        else
        {
            if(breakfast == true)
            {
            roomtotalCost = (regularRoomCost + breakfatCost)* super.getReservationPeriod();
            super.setTotalCost(roomtotalCost);
            }
            else 
            {
            roomtotalCost = regularRoomCost* super.getReservationPeriod();
            super.setTotalCost(roomtotalCost);
                    
            }
        }

    }
}
