package frc.robot.commands.Mamuta;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamuta;

public class PIDMamuta extends CommandBase {

  Mamuta pidMamuta;

  double setPoint;
  double waitTime;

  public PIDMamuta(double setPoint, double waitTime) {
    pidMamuta= Mamuta.getInstance();
    addRequirements(pidMamuta);
    this.setPoint= setPoint;
    this.waitTime=waitTime;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double speed= pidMamuta.calculate(setPoint); 
    pidMamuta.setTalonPower(speed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
