package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class OpenCloseIntake extends CommandBase{

    Intake intake;

    boolean openOrClose;
  
    public OpenCloseIntake(boolean openOrClose) {
      intake = Intake.getInstance();
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
