// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

public class Shooter extends SubsystemBase{
    private TalonFX leftShooter;
    private TalonFX rightShooter;

    private TalonFX shooterArm;

/** Add your docs here. */

public Shooter (){

    leftShooter = new TalonFX(RobotMap.kLeftShooter);
    // Declares leftshooter as an object
    leftShooter.setInverted(true);
    // Leftshooter will be inverted
    leftShooter.configFactoryDefault();
    leftShooter.setNeutralMode(NeutralMode.Brake);
    
    rightShooter = new TalonFX(RobotMap.kRightShooter);
    // Declares rightshooter as an object
    rightShooter.setInverted(false);
    rightShooter.configFactoryDefault();
    rightShooter.setNeutralMode(NeutralMode.Brake);

    shooterArm = new TalonFX(RobotMap.kShooterArm);




}
}
