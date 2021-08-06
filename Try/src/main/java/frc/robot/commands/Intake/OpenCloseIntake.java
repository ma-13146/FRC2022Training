package frc.robot.commands.Intake;

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
    }

    @Override
    public void execute() {
        if(openOrClose){
            intake.setSolenoidMode(true);
        }
        else if(!openOrClose){
            intake.setSolenoidMode(false);
        } 
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }


    
}
