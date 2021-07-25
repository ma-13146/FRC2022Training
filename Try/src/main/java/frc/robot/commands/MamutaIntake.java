package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamuta;

public class MamutaIntake extends CommandBase {

    Mamuta mamutaIntake;
  
    public MamutaIntake() {
      mamutaIntake = Mamuta.getInstance();
      addRequirements(mamutaIntake);
    }
  
    @Override
    public void initialize() {
        mamutaIntake.setVictorPower(1);
    } 
    
}
