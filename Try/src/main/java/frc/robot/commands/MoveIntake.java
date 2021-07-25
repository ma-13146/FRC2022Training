package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    Intake moveIntake;

    boolean forWardOrRevers;

    public MoveIntake(boolean forWardOrRevers){
        moveIntake = Intake.getInstance();
        addRequirements(moveIntake);
        this.forWardOrRevers=forWardOrRevers;
    }

    @Override
    public void initialize() {
        if(forWardOrRevers){
            moveIntake.setTalonsPower(1);
        }

        else if(!forWardOrRevers){
            moveIntake.setTalonsPower(-1);
        }
    }   
}
