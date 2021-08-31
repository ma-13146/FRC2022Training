package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;


public class Shooter extends SubsystemBase {

  private static Shooter instance = null;

  CANSparkMax sparkMax ;
  WPI_TalonSRX talon;

  CANEncoder canEncoder;

  PIDController pid;

  Timer timer;

  double kP=1;
  double kI=1;
  double kD=1;
  
  double low=-1;
  double high=1;

  double lastPlace= 0;
  double lastTime= 0;

  final double maxRPM=5676;

  public Shooter() {
    sparkMax=new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
    talon= new WPI_TalonSRX(1);
    canEncoder= sparkMax.getEncoder();
    canEncoder.setPositionConversionFactor(Constants.tiksPerPulse);
    pid= new PIDController(kP, kI, kD);
    pid.setTolerance(1);
    timer= new Timer();
  }

  public double getPosotion(){
    return canEncoder.getPosition();
  }

  public double getVelocity(){
    return canEncoder.getVelocity();
  }

  public void setSetPoint(double setPoint){
    pid.setSetpoint(setPoint);
  }

  public boolean atSetPoint(){
    return pid.atSetpoint();
  }

  public double calculate(double setPoint){
    return pid.calculate(getVelocity()+setPoint/maxRPM, setPoint);
  }

  public void setSparkMaxPower(double power){
    sparkMax.set(power);
  }

  public void setTalonPower(double power){
      talon.set(power);
  }

  public double getSparkMaxSpeed(){
      return sparkMax.get();
  }


  public static Shooter getInstance() {
    if (instance== null){
      instance= new Shooter();
    }
    return instance;
  }

  public void periodic() {
    SmartDashboard.putBoolean("atSetPoint", pid.atSetpoint());
  }
}

