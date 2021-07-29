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

public class Mamuta extends SubsystemBase{

    private static Mamuta instace= null;

    WPI_TalonSRX talon;

    WPI_VictorSPX victor;
    
    Encoder encoder;
    DigitalInput limitSwitch;

    PIDController pid;

    public Mamuta() {
        talon= new WPI_TalonSRX(1);
        victor= new WPI_VictorSPX(2);
        encoder= new Encoder(1,2, false, EncodingType.k4X);
        limitSwitch= new DigitalInput(3);
        encoder.setDistancePerPulse(1);
        pid= new PIDController(1, 1, 1);
        pid.setTolerance(1);
      }
    
      public void setTalonPower(double power){
          talon.set(ControlMode.PercentOutput, power);
      }

      public void setVictorPower(double power){
        victor.set(ControlMode.PercentOutput, power);
    }
    
      public void setForward(){
      }
    
      public void setReverse(){
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
