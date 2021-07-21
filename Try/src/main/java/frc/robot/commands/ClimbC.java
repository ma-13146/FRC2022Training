package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ClimbC extends CommandBase {

    Climb climb;
    boolean openOrClose;

    public ClimbC(boolean openOrClose){
        climb.getInstace();
        addRequirements(climb);
        this.openOrClose= openOrClose;
    }

    @Override
    public void initialize() {
        if(openOrClose==true){
            climb.setForward();
        }
        else if(openOrClose==false){
            climb.setReverse();
        }
    } 
}
