

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;


public class Robot extends TimedRobot {
  Talon motor1d = new Talon(1);
  Talon motor2d = new Talon(2);
  
  Talon motor1iz = new Talon(3);
  Talon motor2iz = new Talon(4);


  Joystick Xbox = new Joystick(0);

  MotorControllerGroup MotorD = new MotorControllerGroup(motor1d, motor2d);
  MotorControllerGroup Motoriz = new MotorControllerGroup(motor1iz, motor2iz);
  
  DifferentialDrive Chassis = new DifferentialDrive (MotorD , Motoriz);




  
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
   
    MotorD.set(1);
    Motoriz.set(-1);

    Chassis.arcadeDrive(1, 0.5);
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    double adelateAtras = Xbox.getRawAxis(2);
    double izquierdaDerecha = Xbox.getRawAxis(5);
    
    Chassis.arcadeDrive(adelateAtras, izquierdaDerecha);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
