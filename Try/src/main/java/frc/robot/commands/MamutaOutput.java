package frc.robot.commands;

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
        mamutaOutput.setVictorPower(-1);
    }
}
