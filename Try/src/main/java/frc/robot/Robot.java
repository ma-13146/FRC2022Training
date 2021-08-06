package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Mamuta.MamutaMamuta;
import frc.robot.commands.Elevator.ElevatorElevator;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Mamuta;
import frc.robot.commands.Drive.TankDrive;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private MamutaMamuta mamuta;
  private TankDrive joystick;
  private ElevatorElevator elevator;

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();

    mamuta = new MamutaMamuta(Mamuta.getInstance(), 5, 1);// TO CHANGE
    joystick= new TankDrive(Drive.getInstance());
    elevator= new ElevatorElevator(Elevator.getInstace());

    CommandScheduler.getInstance().setDefaultCommand(Drive.getInstance(),joystick);
    CommandScheduler.getInstance().setDefaultCommand(Mamuta.getInstance(), mamuta);
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
