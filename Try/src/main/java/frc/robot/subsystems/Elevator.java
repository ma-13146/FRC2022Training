package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{

    WPI_TalonSRX talon;

    static Elevator instace;

    Encoder encoder;
    DigitalInput limitSwitch;

    PIDController pid;

    double kP=1;
    double kI=1;
    double kD=1;

    double low=-1;
    double high=1;

    public Elevator(){
        talon= new WPI_TalonSRX(6);
        encoder= new Encoder(7,8, false, EncodingType.k4X);
        limitSwitch= new DigitalInput(9);
        encoder.setDistancePerPulse(1);
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

    public void set(double power){
        talon.set(ControlMode.PercentOutput,power);
    }

    public static Elevator getInstace(){
        if (instace== null){
            instace= new Elevator();
          }
          return instace;
    }

    @Override
    public void periodic() {
    }
}

