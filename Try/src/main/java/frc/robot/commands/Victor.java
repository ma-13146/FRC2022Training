package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class Victor extends InstantCommand {

    
      private Intake intake;
      private boolean intakeOrOutput;
    
      public Victor(boolean intakeOrOutput) {
        intake = Intake.getInstance();
        addRequirements(intake);
        this.intakeOrOutput= intakeOrOutput;
      }
    
      @Override
      public void initialize() {
        if(intakeOrOutput== true){
            intake.setPower(1);
      
          }
          else if(intakeOrOutput==false){
            intake.setPower(-1);
          }
      }
     
}
