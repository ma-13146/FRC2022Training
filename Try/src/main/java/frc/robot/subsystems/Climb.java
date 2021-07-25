package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

    static Climb instace;

    DoubleSolenoid doubleSolenoid;

    public Climb(){
        doubleSolenoid= new DoubleSolenoid(2,3);
    }

    public void setForward(){
        doubleSolenoid.set(Value.kForward);
    }

    public void setReverse(){
        doubleSolenoid.set(Value.kReverse);
    }

    public Climb getInstace(){
        if (instace== null){
            instace= new Climb();
        }
            return instace;
    }

    @Override
    public void periodic() {
    }


    
}
