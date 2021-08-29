package frc.robot.commands.Intake;

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
    }

    @Override
    public void execute() {
      intake.setVictorPower(1);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
