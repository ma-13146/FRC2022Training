package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamuta;

public class Intake extends CommandBase {

    Mamuta mamuta;
  
    public Intake() {
      mamuta = Mamuta.getInstance();
      addRequirements(mamuta);
    }
  
    @Override
    public void initialize() {
        mamuta.setVictorPower(1);
    } 
    
}
