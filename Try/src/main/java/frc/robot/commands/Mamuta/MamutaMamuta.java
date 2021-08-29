package frc.robot.commands.Mamuta;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotContainer;
import frc.robot.subsystems.Mamuta;

public class MamutaMamuta extends CommandBase {

    
  Mamuta mamuta;
  double setPoint;
  double waitTime;
  
  public MamutaMamuta(Mamuta mamuta, double setPoint, double waitTime) {
    this.setPoint= setPoint;
    this.mamuta = mamuta;
    this.waitTime= waitTime;
    addRequirements(mamuta);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double speed=mamuta.calculate(setPoint);
    mamuta.setTalonPower(speed);
    if (mamuta.get()){
      mamuta.setVictorPower(1);
      mamuta.setSetPoint(0);
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
