package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{

    WPI_TalonSRX talon;

    static Elevator instace;

    Encoder encoder;
    DigitalInput limitSwitch;

    public Elevator(){
        talon= new WPI_TalonSRX(6);
        encoder= new Encoder(7,8, false, EncodingType.k4X);
        limitSwitch= new DigitalInput(9);
        encoder.setDistancePerPulse(1);
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

