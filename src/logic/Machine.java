/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Machine {

    private int numberMachine;
    /**
     * machine number
     */
    private int machineType;
    /**
     * machine type
     */
    private long accountantIn;
    /**
     * account in
     */
    private long accountantOut;
    /**
     * account out
     */
    private Date day;
    
    /**
     * Bet Value
     */
    
    private long BetValue;

  

    /**
     * Default Constructor
     */
    
    
    
    
    public Machine() {
        this.numberMachine = 0;
        this.accountantIn = 0;
        this.accountantOut = 0;
        this.day = new Date();
        this.BetValue = 0;
    }

    /**
     *
     * @param numberMachine number machine
     * @param accountantIn input accountant
     * @param accountantOut out accountant
     */
    public Machine(long BetValue,int numberMachine, long accountantIn, long accountantOut, Date day) {
        this.numberMachine = numberMachine;
        this.accountantIn = accountantIn;
        this.accountantOut = accountantOut;
        this.day = day;
        this.BetValue = BetValue;
    }

    /**
     * Get BetValue
     * @return Bet vale
     */
      public long getBetValue() {
        return BetValue;
    }
      
      /**
       * Change Bet Value
       * @param BetValue 
       */

    public void setBetValue(long BetValue) {
        this.BetValue = BetValue;
    }
     /**
      * Get Number Machine
      * @return Number Mcahine
      */
    
    public int getNumberMachine() {
        return numberMachine;
    }

    /**
     * Change Number Machine
     * @param numberMachine 
     */
    public void setNumberMachine(int numberMachine) {
        this.numberMachine = numberMachine;
    }

    /**
     * Get Machine Type
     * @return Machine Type
     */
    public int getMachineType() {
        return machineType;
    }

    /**
     * Change Machine Type
     * @param machineType 
     */
    public void setMachineType(int machineType) {
        this.machineType = machineType;
    }

    /**
     * Get Accountant In
     * @return Accountant In
     */
    public long getAccountantIn() {
        return accountantIn;
    }

    /**
     * Change Accountant In
     * @param accountantIn 
     */
    public void setAccountantIn(long accountantIn) {
        this.accountantIn = accountantIn;
    }

    /**
     * Get Accountan Out
     * @return Accountant Out
     */
    public long getAccountantOut() {
        return accountantOut;
    }

    /**
     * Change Accountant Out
     * @param accountantOut 
     */
    public void setAccountantOut(long accountantOut) {
        this.accountantOut = accountantOut;
    }

    /**
     * Get Date Adquisitation Machine
     * @return  Date Adquisitation Machine
     */
    public Date getDay() {
        return day;
    }

    /**
     * Change  Date Adquisitation Machine
     * @param day 
     */
    public void setDay(Date day) {
        this.day = day;
    }

}
