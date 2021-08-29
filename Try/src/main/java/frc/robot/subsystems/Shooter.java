package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;


public class Shooter extends SubsystemBase {

  private static Shooter instance = null;

  CANSparkMax sparkMax ;
  WPI_TalonSRX talon;

  Encoder encoder;

  PIDController pid;

  Timer timer;

  double kP=1;
  double kI=1;
  double kD=1;
  
  double low=-1;
  double high=1;

  double lastPlace= 0;
  double lastTime= 0;

  final double maxRPM=5676;// is it right?

  public Shooter() {
    sparkMax=new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
    talon= new WPI_TalonSRX(1);
    encoder= new Encoder(1,2, false, EncodingType.k4X);
    pid= new PIDController(kP, kI, kD);
    pid.setTolerance(1);
    timer= new Timer();
  }


// return seconds
  public double getCurrentTime(){
      return timer.get();
  }

  public double getDistance(){
    return encoder.getDistance();
  }

  public void setSetPoint(double setPoint){
    pid.setSetpoint(setPoint);
  }

  public boolean atSetPoint(){
    return pid.atSetpoint();
  }

  public double speedSource(){
    double currentDistance= getDistance();
    double daltaDistance=currentDistance-lastPlace;
    lastPlace=currentDistance;

    double currentTime= getCurrentTime();
    double deltaTime=currentTime-lastTime;
    lastTime= currentTime;

    double speed= daltaDistance/deltaTime;//is it right?
    return speed;
  }


  public double calculate(double setPoint){
    return pid.calculate(speedSource()+setPoint/maxRPM, setPoint);
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

