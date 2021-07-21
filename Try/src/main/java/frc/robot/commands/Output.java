package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamuta;

public class Output extends CommandBase {

    Mamuta mamuta;
  
    public Output() {
      mamuta = Mamuta.getInstance();
      addRequirements(mamuta);
    }
  
    @Override
    public void initialize() {
        mamuta.setVictorPower(-1);
    }
}
