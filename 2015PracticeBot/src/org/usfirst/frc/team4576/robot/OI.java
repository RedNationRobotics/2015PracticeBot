package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.Shift;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Button blx = new JoystickButton(Robot.leftstick, 3);

	public OI() {
		blx.whenPressed(new Shift());
	}
}