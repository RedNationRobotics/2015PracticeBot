package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	Compressor c = new Compressor();
	Solenoid s0 = new Solenoid(0);
	private AnalogInput apsensor;
	private double pVoltage;
	
	
	@Override
	protected void initDefaultCommand() {

	}

	public void setAutoEnabled() {
	
	}

	public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shift() {
		s0.set(!s0.get());

	}
	
	public double pressureVoltage() {
		apsensor = new AnalogInput(0);
		return pVoltage;
		
		
		
	}
//	public double pVoltage(){
	//	return pressureVoltage();
	}
	
