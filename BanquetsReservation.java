
package com.flip.gmzhotel;


public class BanquetsReservation extends Reservation{
    
    private static double numberOfbanquetsReservation = 0;
    private final double smallBanquetCostPerPearon = 20 , bigBanquetCostPerPearon = 45, menu1Cost = 30.5, menu2Cost = 55 ;
    private int banquetType;
    private int menuType, numberOfInvited;
    private double totaBanquetCost;
    
    public BanquetsReservation(String reservationName,String reservationDate,int reservationPeriod, int banquetType,int menuType, int numberOfInvited)
            
    {
        super(reservationName,reservationDate,reservationPeriod);
        
        this.banquetType = banquetType;
        this.menuType = menuType;
        this.numberOfInvited = numberOfInvited;
        
        numberOfbanquetsReservation += 1;
    }

    public int getBanquetType() {
        return banquetType;
    }

    public void setBanquetType(char banquetType) {
        this.banquetType = banquetType;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public static double getNumberOfbanquetsReservation() {
        return numberOfbanquetsReservation;
    }

    public double getSmallBanquetCostPerPearon() {
        return smallBanquetCostPerPearon;
    }

    public double getBigBanquetCostPerPearon() {
        return bigBanquetCostPerPearon;
    }

    public double getTotaBanquetCost() {
        return totaBanquetCost;
    }

    public double getMenu1Cost() {
        return menu1Cost;
    }

    public double getMenu2Cost() {
        return menu2Cost;
    }

    public int getNumberOfInvited() {
        return numberOfInvited;
    }

    public void setNumberOfInvited(int numberOfInvited) {
        this.numberOfInvited = numberOfInvited;
    }
    
    
    public void calculateTotalCost()
    {
        if (banquetType == 1)
        {
            if (menuType == 1)
            {
                totaBanquetCost = ((numberOfInvited *(smallBanquetCostPerPearon + menu1Cost))) * super.getReservationPeriod();
                super.setTotalCost(totaBanquetCost);
            }
            else
            {
                totaBanquetCost = ((numberOfInvited * (smallBanquetCostPerPearon + menu2Cost))) * super.getReservationPeriod();
                super.setTotalCost(totaBanquetCost);
            }
        }
        else
        {
            if (menuType == 1)
            {
                totaBanquetCost = ((numberOfInvited *(bigBanquetCostPerPearon + menu1Cost)))* super.getReservationPeriod();
                super.setTotalCost(totaBanquetCost);
            }
            else
            {
                totaBanquetCost = ((numberOfInvited * (bigBanquetCostPerPearon + menu2Cost)))* super.getReservationPeriod();
                super.setTotalCost(totaBanquetCost);
            }
        }
    }
    
}
