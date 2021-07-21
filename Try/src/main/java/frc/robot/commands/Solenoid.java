package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class Solenoid extends  InstantCommand {
    Intake intake;
    boolean forWardOrRevers;
  
    public Solenoid(boolean forWardOrRevers) {
      intake = Intake.getInstance();
      addRequirements(intake);
      this.forWardOrRevers= forWardOrRevers;
    }
  
    @Override
    public void initialize() {
      if (forWardOrRevers==true){
        intake.setForward();
      }
  
      else if( forWardOrRevers== false){
        intake.setReverse();
      }
    }  
}
