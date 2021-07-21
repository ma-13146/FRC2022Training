package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Mamuta;

public class Axle extends CommandBase {

    
  Mamuta axle;
  
  public Axle(Mamuta M) {
    addRequirements(M);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
      if(RobotContainer.firstXboxJoystick.getY()==0){
        //איך להפעיל פה את הקומנד של האינטייק?
      }
      else{
        axle.setTalonPower(RobotContainer.firstXboxJoystick.getY());
    }    
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
    
}
