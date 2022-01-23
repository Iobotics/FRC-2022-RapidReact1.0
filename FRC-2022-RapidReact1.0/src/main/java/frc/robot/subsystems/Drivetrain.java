// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

/** Add your docs here. */

public class Drivetrain extends SubsystemBase{

/* First, we declare our four motors for the drivetrain
We are going to use NEO motors and have a leader (master) and follower (slave) on each side
*/
    private CANSparkMax leftMaster;
    private CANSparkMax leftSlave;
    private CANSparkMax rightMaster;
    private CANSparkMax rightSlave;

    public DifferentialDrive drive;

/* DifferentialDrive is when the robot is controlled by wheels on each side. 
Steering is controlled by motor speed and direction */
    
    public Drivetrain(){

//THE FOLLOWING NEEDS TO BE DECLARED IN CONSTANTS (PID DRIVE RELATED)
// CANSparkMax(device number, type of motor (NEO brushless in this case))
        leftMaster = new CANSparkMax(RobotMap.kLeftMaster, MotorType.kBrushless); //CAN 0
        leftSlave = new CANSparkMax(RobotMap.kLeftSlave, MotorType.kBrushless); //CAN 1
        rightMaster = new CANSparkMax(RobotMap.kRightMaster, MotorType.kBrushless); //CAN 2
        rightSlave = new CANSparkMax(RobotMap.kRightSlave, MotorType.kBrushless); //CAN 3
        drive = new DifferentialDrive(leftMaster, rightMaster);
 
        //Set Motor Polarities (is it going to be inverted?)
        leftMaster.setInverted(false);
        leftSlave.setInverted(false);
        rightMaster.setInverted(false);
        rightSlave.setInverted(false);

        //Slave motors to follow Master motors
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);

        /* The RestoreFactoryDefaults method can be used to reset the configuration parameters
        in the SPARK MAX to their factory default state. If no argument is passed, these
        parameters will not persist between power cycles
        */
        leftMaster.restoreFactoryDefaults();
        rightMaster.restoreFactoryDefaults();

    } 


    
    

}
