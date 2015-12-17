
package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4576.robot.commands.AutoEnableCompressor;
import org.usfirst.frc.team4576.robot.commands.Autonomous;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.OnboardAccel;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

public class Robot extends IterativeRobot {

	
	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final OnboardAccel accel = new OnboardAccel();
	

	// attempted to ASSIGN DATA AND CREATE VARIABLE FOR RANGE AND THEN MAKE SMARTDASHBOARD
	// WIDGET********, failed.

	public static OI oi;
	public static final String VERSION = "4.2.0-TEST";
	

	public static Joystick leftstick = new Joystick(0);
	Command autonomousCommand;
	Command teleopCommand;
	Command compressorStart;

	public void robotInit() {
		System.out.println(
				"RNR DANK MEME BOT VROOME VROOM GO FAST WATCH OUT HURT" + VERSION + "1.03" + "is loading.....");
		oi = new OI();
		teleopCommand = new DriveWithJoysticks();
		autonomousCommand = new Autonomous();
		compressorStart = new AutoEnableCompressor();
		
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		if (autonomousCommand != null)autonomousCommand.start();
		//added <autochooser.getSelected();> might be wrong (s)
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running.
		if (autonomousCommand != null)autonomousCommand.cancel();
		teleopCommand.start();
		compressorStart.start();
	}

	public void disabledInit() {

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}