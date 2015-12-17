package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;



public class PressureSensor extends Pneumatics {
//*****
	AnalogInput channel = new AnalogInput(0);
//*****
	private final double VOLTAGE_TO_PSI_CONVERSION = 0.25;
    private boolean use_units;    //Are we using units or just returning voltage?
    private double min_voltage;	  //Minimum voltage the pressure sensor can return
    private double voltage_range; //The range of the voltages returned by the sensor (maximum - minimum)
    private double min_psi;
    private double psi_range;//The range of the psi returned by this class in voltage (maximum - minimum)
 
    //constructor
    public PressureSensor(int _0) {
    	//*****
        //channel = new AnalogInput(_0);
        //*****
        //default values
		use_units = true;
		min_voltage = 0.25;
		voltage_range = 5.0 - min_voltage;
		min_psi = 0;
		psi_range = 200.0 - min_psi;
    }
    //constructor
    //0 = channel
    public PressureSensor(int _0, boolean _use_units, double _min_voltage,
            double _max_voltage, double _min_psi, double _max_psi) {
        channel = new AnalogInput(_0);
        //only use unit-specific variables if we're using units
        if (_use_units) {
            use_units = true;
            min_voltage = _min_voltage;
            voltage_range = _max_voltage - _min_voltage;
            min_psi = _min_psi;
            psi_range = _max_psi - _min_psi;
        }
    }
    // Just get the voltage.
    double GetVoltage() {
        return channel.getVoltage();
    }
    /* GetRangeInpsi
     * Returns the range in psi
     * Returns -1.0 if units are not being used
     * Returns -2.0 if the voltage is below the minimum voltage
     */

    double GetRangeInpsi() {
        double range;
        //if we're not using units, return -1, a range that will most likely never be returned
        if (!use_units) {
            return -1.0;
        }
        range = channel.getVoltage();
        if (range < min_voltage) {
            return -2.0;
        }
        //first, normalize the voltage
        range = (range - min_voltage) / voltage_range;
        //next, denormalize to the unit range
        range = (range * psi_range) + min_psi;
        return range;
    }
    
}