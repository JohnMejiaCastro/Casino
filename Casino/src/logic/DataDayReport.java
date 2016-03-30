/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class DataDayReport {

    private Date dayDate;
    /**
     * Date Report day
     */
//    private Date dayDate2;  /** Date Report day */ 
    private String numberMachine;
    /**
     * Number Machine
     */

    
    private long machineInputDayCurrent;
    /**
     * Current Input Day
     */
    private long machineOutDayCurrent;
    /**
     * Current Output day
     */


    /**
     * Resul Day
     */

    /**
     * Default Construtctor
     */
    public DataDayReport() {
        this.dayDate = new Date();
        this.numberMachine = "";
        this.machineInputDayCurrent = 0;
        this.machineOutDayCurrent = 0;
    }

    /**
     *
     *
     * @param dayDate Date Report Day
     * @param numberMachine Number Machine
     * @param machineInputDayCurrent Current Input Day
     * @param machineOutDayCurrent Current Output day
     */
    public DataDayReport(Date dayDate2, int resultDay, Date dayDate, String numberMachine, long availableMoney, long expensesEmployee, long machineInputDayCurrent, long machineOutDayCurrent) {
        this.dayDate = dayDate;
        this.numberMachine = numberMachine;     
        this.machineInputDayCurrent = machineInputDayCurrent;
        this.machineOutDayCurrent = machineOutDayCurrent;
    }

    

    
    /**
     * Get Date day
     *
     * @return Date Report day
     */
    public Date getDayDate() {
        return dayDate;
    }


    /**
     * Change Date Report day
     * @param dayDate 
     */
    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    /**
     * Get Number Machine
     * @return Number Machine
     */
    public String getNumberMachine() {
        return numberMachine;
    }

    /**
     * Change Number Machine
     * @param numberMachine 
     */
    public void setNumberMachine(String numberMachine) {
        this.numberMachine = numberMachine;
    }

    
    /**
     * Get Current Input Day
     * @return Current Input Day
     */
    public long getMachineInputDayCurrent() {
        return machineInputDayCurrent;
    }

    /**
     * Change Current Input Day
     * @param machineInputDayCurrent 
     */
    public void setMachineInputDayCurrent(long machineInputDayCurrent) {
        this.machineInputDayCurrent = machineInputDayCurrent;
    }

    /**
     * Get Current Output Day
     * @return Current Output Day
     */
    public long getMachineOutDayCurrent() {
        return machineOutDayCurrent;
    }

    /**
     * Change Current Output Day
     * @param machineOutDayCurrent 
     */
    public void setMachineOutDayCurrent(long machineOutDayCurrent) {
        this.machineOutDayCurrent = machineOutDayCurrent;
    }

}
