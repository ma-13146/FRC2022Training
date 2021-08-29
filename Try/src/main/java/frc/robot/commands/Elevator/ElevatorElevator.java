package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorElevator extends CommandBase {

    Elevator elevator;

    double setPoint;
    double waitTime;

    public ElevatorElevator(Elevator elevator, double setPoint, double waitTime){
        this.elevator=elevator;
        addRequirements(elevator);
        this.setPoint= setPoint;
        this.waitTime=waitTime;
    }

    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {

      //elevator.set(RobotContainer.secondXboxJoystick.getY(Hand.kLeft));

      double speed= elevator.calculate(setPoint);
      elevator.set(speed);

      if (elevator.atSetPoint()){
        elevator.setSetPoint(0);
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
