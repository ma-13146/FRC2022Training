package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{

    WPI_VictorSPX victor;
    Solenoid solenoid;

    WPI_TalonSRX firstTalon;
    WPI_TalonSRX secondTalon;
    
    static Intake instace = null;

    Encoder encoder;
    DigitalInput limitSwitch;

    PIDController pid;


    double kP=1;
    double kI=1;
    double kD=1;

    double low=-1;
    double high=1;
  
  
    public Intake() {
        firstTalon= new WPI_TalonSRX(3);
        secondTalon= new WPI_TalonSRX(4);
        victor= new WPI_VictorSPX(5);
        solenoid= new Solenoid(1);
        encoder= new Encoder(4,5, false, EncodingType.k4X);
        limitSwitch= new DigitalInput(6);
        encoder.setDistancePerPulse(1);
        pid= new PIDController(kP, kI, kD);
        pid.setTolerance(1);
        secondTalon.follow(firstTalon);
    }

    public void setSetPoint(double setPoint){
      pid.setSetpoint(setPoint);
    }

    public boolean atSetPoint(){
      return pid.atSetpoint();
    }


    public double calculate(double setPoint){
      return pid.calculate(encoder.getDistance(), setPoint);
    }
  
    public void setVictorPower(double power){
      victor.set(ControlMode.PercentOutput, power);
    }

    public void setTalonsPower(double power){
        firstTalon.set(ControlMode.PercentOutput, power);
      }


    public void setSolenoidMode(boolean solenoidMode){
        solenoid.set(solenoidMode);
    }
  
    
    public static Intake getInstance(){
      if (instace== null){
        instace= new Intake();
      }
      return instace;
    }
  
    @Override
    public void periodic() {
      if(limitSwitch.get()){
        encoder.reset();
      }
      SmartDashboard.putNumber("encoderDistance", encoder.getDistance());
      SmartDashboard.putBoolean("limitPress", limitSwitch.get());
    }
    
}
