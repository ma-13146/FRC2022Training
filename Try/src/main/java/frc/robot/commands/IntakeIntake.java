package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeIntake extends CommandBase {

    Intake intake;
  
    public IntakeIntake() {
      intake = Intake.getInstance();
      addRequirements(intake);
    }
  
    @Override
    public void initialize() {
        intake.setVictorPower(1);
    }
}
