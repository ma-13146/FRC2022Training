package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Mamuta;

public class MamutaMamuta extends CommandBase {

    
  Mamuta mamuta;
  
  public MamutaMamuta(Mamuta mamuta) {
    this.mamuta = mamuta;
    addRequirements(mamuta);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    mamuta.setTalonPower(RobotContainer.firstXboxJoystick.getY());   
    mamuta.setVictorPower(1);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
    
}
