package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Mamuta extends SubsystemBase{

    private static Mamuta instace= new Mamuta();

    WPI_TalonSRX talon;

    WPI_VictorSPX victor;

    public Mamuta() {
        talon= new WPI_TalonSRX(1);
        victor= new WPI_VictorSPX(2);
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
    
      
      public static Mamuta getInstance() {
        if (instace== null){
          instace= new Mamuta();
        }
        return instace;
      }
    
      @Override
      public void periodic() {
      }


    
}
