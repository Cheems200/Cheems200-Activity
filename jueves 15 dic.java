

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.util.WPIUtilJNI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;





public class Robot extends TimedRobot {

  WPI_TalonSRX motord1 = new WPI_TalonSRX(0);
  WPI_TalonSRX motord2 = new WPI_TalonSRX(1);
  MotorControllerGroup MotoresDerecha = new MotorControllerGroup(motord1, motord2);
  
  WPI_TalonSRX motoriz1 = new WPI_TalonSRX(2);
  WPI_TalonSRX motoriz2 = new WPI_TalonSRX(3);
  MotorControllerGroup MotoresIzquierda = new MotorControllerGroup(motoriz1, motoriz2);

  DifferentialDrive jamon = new DifferentialDrive(MotoresDerecha, MotoresIzquierda);

  // Joystick //
  Joystick Xbox = new Joystick(0);

  // Intake //
  WPI_TalonSRX AGARRAPELOTAS = new WPI_TalonSRX(4);
  Solenoid BOLASCONTRAIDAS = new Solenoid(PneumaticsModuleType.CTREPCM, 7);

  //Disparador//
  WPI_TalonFX disparador1 = new WPI_TalonFX(5);
  WPI_TalonFX disparador2 = new WPI_TalonFX(6);
  DifferentialDrive disparadores = new DifferentialDrive(disparador1, disparador2);





  @Override
  public void robotPeriodic() {}

 
  @Override
  public void disabledInit() {}





  @Override
  public void disabledPeriodic() {}





  @Override
  public void autonomousInit() {






  }

 

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}


  @Override
  public void teleopPeriodic() {
  

    //MOVEMENT//
    double avanzarRetro = Xbox.getRawAxis(2);
    double IzquerdaDerecha = Xbox.getRawAxis(5);
    jamon.arcadeDrive(avanzarRetro, IzquerdaDerecha);

    //INTAKE//
    
    if(Xbox.getRawButton(1) == true){
      sacarAGARRABOLAS();

    }else{
      meterAGARRABOLAS();
    }
     
    




  }





  @Override
  public void testInit() {




  }


  @Override
  public void testPeriodic() {}


  @Override
  public void simulationInit() {}

 
  @Override
  public void simulationPeriodic() {}




  public void sacarAGARRABOLAS () {

    AGARRAPELOTAS.set(0.5);
    BOLASCONTRAIDAS.set(true);
  }

  public void meterAGARRABOLAS () {

    AGARRAPELOTAS.set(0.5);
    BOLASCONTRAIDAS.set(false);


  }  

  public void disparador() {

    if(Xbox.getRawButton(5)){
      disparadores.arcadeDrive(1, 0);
    }else{
      disparadores.arcadeDrive(0, 0);
    } }     }
    
  