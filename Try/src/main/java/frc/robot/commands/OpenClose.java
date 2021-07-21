package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NewIntake;

public class OpenClose extends CommandBase{

    NewIntake intake;

    boolean openOrClose;
  
    public OpenClose(boolean openOrClose) {
      intake = NewIntake.getInstance();
      addRequirements(intake);
      this.openOrClose= openOrClose;
    }
  
    @Override
    public void initialize() {
        if(openOrClose){
            intake.setSolenoidMode(true);
        }
        else if(!openOrClose){
            intake.setSolenoidMode(false);
        }    
    }


    
}
