package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  WPI_VictorSPX victor;
  static Intake instace = null;

  DoubleSolenoid doubleSolenoid;

  public Intake() {
    victor= new WPI_VictorSPX(1);
    doubleSolenoid=  new DoubleSolenoid(2,3);
  }

  public void setPower(double power){
    victor.set(ControlMode.PercentOutput, power);
  }

  public void setForward(){
    doubleSolenoid.set(Value.kForward);
  }

  public void setReverse(){
    doubleSolenoid.set(Value.kReverse);
  }

  
  public static Intake getInstance(){
    if (instace== null){
      instace= new Intake();
    }
    return instace;
  }

  @Override
  public void periodic() {
  }
}
