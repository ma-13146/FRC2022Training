package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterShooter extends CommandBase {

    Shooter shooter;

    double setPoint;
  
    public ShooterShooter(double setPoint) {
        shooter = Shooter.getInstance();
        addRequirements(shooter);
        this.setPoint= setPoint;
    }
  
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double speed= shooter.calculate(setPoint);
        shooter.setSparkMaxPower(speed);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
