package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;

public class Mamuta extends SubsystemBase{

    private static Mamuta instace= null;

    WPI_TalonSRX talon;

    WPI_VictorSPX victor;
    
    Encoder encoder;
    DigitalInput limitSwitch;

    PIDController pid;

    double kP=1;
    double kI=1;
    double kD=1;

    double low=-1;
    double high=1;

    public Mamuta() {
        talon= new WPI_TalonSRX(1);
        victor= new WPI_VictorSPX(2);
        encoder= new Encoder(1,2, false, EncodingType.k4X);
        limitSwitch= new DigitalInput(3);
        encoder.setDistancePerPulse(1);
        pid= new PIDController(kP, kI, kD);
        pid.setTolerance(1);
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


      public double calculate(double setPoint){
        return pid.calculate(encoder.getDistance(), setPoint);
      }
    
      public void setTalonPower(double power){
          talon.set(ControlMode.PercentOutput, power);
      }

      public void setVictorPower(double power){
        victor.set(ControlMode.PercentOutput, power);
      }

      public void getReset(){
        encoder.reset();
      }

      public boolean get(){
        return limitSwitch.get();
      }
    
      public static Mamuta getInstance() {
        if (instace== null){
          instace= new Mamuta();
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
