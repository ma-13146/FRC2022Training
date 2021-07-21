package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NewIntake extends SubsystemBase{

    WPI_VictorSPX victor;
    Solenoid solenoid;

    WPI_TalonSRX firstTalon;
    WPI_TalonSRX secondTalon;
    static NewIntake instace = null;
  
  
    public NewIntake() {
        firstTalon= new WPI_TalonSRX(1);
        secondTalon= new WPI_TalonSRX(2);
        victor= new WPI_VictorSPX(3);
        solenoid= new Solenoid(4);

        secondTalon.follow(firstTalon);
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
  
    
    public static NewIntake getInstance(){
      if (instace== null){
        instace= new NewIntake();
      }
      return instace;
    }
  
    @Override
    public void periodic() {
    }
    
}
