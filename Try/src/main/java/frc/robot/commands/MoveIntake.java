package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NewIntake;

public class MoveIntake extends CommandBase {

    NewIntake intake;

    boolean forWardOrRevers;

    public MoveIntake(boolean forWardOrRevers){
        intake = NewIntake.getInstance();
        addRequirements(intake);
        this.forWardOrRevers=forWardOrRevers;
    }

    @Override
    public void initialize() {
        if(forWardOrRevers){
            intake.setTalonsPower(1);
        }

        else if(!forWardOrRevers){
            intake.setTalonsPower(-1);
        }
    }



    
}
