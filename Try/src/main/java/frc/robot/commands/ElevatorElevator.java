package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Elevator;

public class ElevatorElevator extends CommandBase {

    Elevator elevator;

    public ElevatorElevator(Elevator elevator){
        this.elevator=elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {
      elevator.set(RobotContainer.secondXboxJoystick.getY(Hand.kLeft));
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }



    
}
