package frc.robot.commands.Climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ClimbClimb extends CommandBase {

    Climb climb;
    boolean openOrClose;

    public ClimbClimb(boolean openOrClose){
        climb= Climb.getInstace();
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
