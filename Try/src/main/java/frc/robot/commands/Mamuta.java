package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Mamuta extends CommandBase {

    
    frc.robot.subsystems.Mamuta mamuta;
  
  public Mamuta(frc.robot.subsystems.Mamuta mamuta) {
    this.mamuta = mamuta;
    addRequirements(this.mamuta);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    mamuta.setTalonPower(RobotContainer.firstXboxJoystick.getY());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
    
}
