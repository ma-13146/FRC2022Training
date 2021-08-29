package frc.robot.commands.Mamuta;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamuta;

public class MamutaOutput extends CommandBase {

    Mamuta mamutaOutput;
  
    public MamutaOutput() {
      mamutaOutput = Mamuta.getInstance();
      addRequirements(mamutaOutput);
    }
  
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
      mamutaOutput.setVictorPower(-1);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
