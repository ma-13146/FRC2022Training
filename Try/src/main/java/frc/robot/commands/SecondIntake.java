package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NewIntake;

public class SecondIntake extends CommandBase {

    NewIntake intake;
  
    public SecondIntake() {
      intake = NewIntake.getInstance();
      addRequirements(intake);
    }
  
    @Override
    public void initialize() {
        intake.setVictorPower(1);
    }
}
