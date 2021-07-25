package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MoveMamuta;
import frc.robot.commands.ElevatorElevator;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Mamuta;
import frc.robot.commands.TankDrive;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private MoveMamuta axle;
  private TankDrive joystick;
  private ElevatorElevator elevator;

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();

    axle = new MoveMamuta(Mamuta.getInstance());
    joystick= new TankDrive(Drive.getInstance());
    elevator= new ElevatorElevator(Elevator.getInstace());

    CommandScheduler.getInstance().setDefaultCommand(Drive.getInstance(),joystick);
    CommandScheduler.getInstance().setDefaultCommand(Mamuta.getInstance(), axle);
    CommandScheduler.getInstance().setDefaultCommand(Elevator.getInstace(), elevator);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}
