package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter extends SubsystemBase {

  private static Shooter instance = null;

  CANSparkMax sparkMax ;
  WPI_TalonSRX talon;

  Encoder encoder;

  PIDController pid;

  public Shooter() {
    sparkMax=new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
    talon= new WPI_TalonSRX(1);
    encoder= new Encoder(1,2, false, EncodingType.k4X);
    
  }

  public void setSparkMaxPower(double power){
    sparkMax.set(power);
  }

  public void setTalonPower(double power){
      talon.set(power);
  }






  public static Shooter getInstance() {
    if (instance== null){
      instance= new Shooter();
    }
    return instance;
  }

  public void periodic() {
  }

}

