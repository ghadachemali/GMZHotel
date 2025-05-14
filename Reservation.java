
package com.flip.gmzhotel;

public class Reservation {
    private static double numberOfReservation =0;
    private String reservationName, reservationDate;
    private int reservationPeriod;
    private double totalCost;

    
    public Reservation(String reservationName, String reservationDate, int reservationPeriod)
    {
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.reservationPeriod = reservationPeriod;
        numberOfReservation += 1;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationPeriod() {
        return reservationPeriod;
    }

    public void setReservationPeriod(int reservationPeriod) {
        this.reservationPeriod = reservationPeriod;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public static double getNumberOfReservation() {
        return numberOfReservation;
    }
    

}
