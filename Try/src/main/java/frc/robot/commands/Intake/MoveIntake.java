package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class MoveIntake extends CommandBase {

    Intake moveIntake;

    boolean forWardOrRevers;

    double setPoint;

    public MoveIntake(double setPoint, double waitTime){
        moveIntake = Intake.getInstance();
        addRequirements(moveIntake);
        this.setPoint=setPoint;
    }

    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
        double speed= moveIntake.calculate(setPoint);
        moveIntake.setTalonsPower(speed);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
