package frc.robot.commands.Mamuta;

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
    } 

    @Override
    public void execute() {
      mamutaIntake.setVictorPower(1);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }

    
    
}
