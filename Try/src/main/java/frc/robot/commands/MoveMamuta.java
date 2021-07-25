package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Mamuta;

public class MoveMamuta extends CommandBase {

    
  Mamuta moveMamuta;
  
  public MoveMamuta(Mamuta M) {
    addRequirements(M);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    moveMamuta.setTalonPower(RobotContainer.firstXboxJoystick.getY());   
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
    
}
