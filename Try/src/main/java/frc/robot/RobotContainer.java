package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Climb.ClimbClimb;
import frc.robot.commands.Mamuta.MamutaIntake;
import frc.robot.commands.Intake.MoveIntake;
import frc.robot.commands.Intake.OpenCloseIntake;
import frc.robot.commands.Mamuta.MamutaOutput;
import frc.robot.commands.Intake.IntakeIntake;

public class RobotContainer {

  public static Joystick joystick1 = new Joystick(1);
  public static Joystick joystick2= new Joystick(2);


  private JoystickButton aButton= new JoystickButton(joystick1,1);
  private JoystickButton bButton= new JoystickButton(joystick1,2);
  private JoystickButton cButton= new JoystickButton(joystick1,3);
  private JoystickButton dButton= new JoystickButton(joystick1,4);

  private JoystickButton eButton= new JoystickButton(joystick1,5);
  private JoystickButton fButton= new JoystickButton(joystick1,6);

  private JoystickButton gButton= new JoystickButton(joystick1,7);

  private JoystickButton hButton= new JoystickButton(joystick1,8);
  private JoystickButton iButton= new JoystickButton(joystick1,9);

  public static XboxController firstXboxJoystick= new XboxController(10);
  public static XboxController secondXboxJoystick= new XboxController(11);


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

    aButton.whenHeld(new ClimbClimb(true));
    bButton.whenHeld(new ClimbClimb(false));

    cButton.whenHeld(new MoveIntake(true));
    dButton.whenHeld(new MoveIntake(false));

    eButton.whenHeld(new MamutaIntake());

    fButton.whenHeld(new MamutaOutput());

    gButton.whenHeld(new IntakeIntake());

    hButton.whenHeld(new OpenCloseIntake(true));
    iButton.whenHeld(new OpenCloseIntake(false));

  }

  public Command getAutonomousCommand() {
    return null;
  }

}
