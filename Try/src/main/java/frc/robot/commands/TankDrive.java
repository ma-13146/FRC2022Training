package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class TankDrive extends CommandBase {

  Drive drive;
  
  public TankDrive(Drive drive) {
    this.drive =drive;
    addRequirements(drive);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    drive.setRight(RobotContainer.joystick1.getY()+RobotContainer.joystick2.getX());
    drive.setLeft(RobotContainer.joystick1.getY()-RobotContainer.joystick2.getX());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
