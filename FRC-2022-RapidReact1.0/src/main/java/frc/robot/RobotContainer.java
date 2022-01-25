// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Joystick joystick1 = new Joystick(OIConstants.kJoystick1);
  private final Joystick joystick2 = new Joystick(OIConstants.kJoystick2);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(new RunCommand(
      () -> drivetrain.drive.tankDrive(joystick1.getY(), joystick2.getY())));

    


  }

  
   //Use this method to define your button->command mappings. Buttons can be created by
   //instantiating a {@link GenericHID} or one of its subclasses ({@link
   //edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   // edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   
  private void configureButtonBindings() {
    new JoystickButton(joystick2, 2).whileHeld(
        new StartEndCommand(
          ()-> intake.setPower(joystick2.getZ()),
          ()-> intake.stop())
        );
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
