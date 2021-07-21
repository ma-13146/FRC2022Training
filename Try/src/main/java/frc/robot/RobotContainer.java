package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimbC;
import frc.robot.commands.Intake;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.OpenClose;
import frc.robot.commands.Output;
import frc.robot.commands.SecondIntake;
import frc.robot.commands.Solenoid;
import frc.robot.commands.Victor;

public class RobotContainer {

  public static Joystick joystick1 = new Joystick(0);
  public static Joystick joystick2= new Joystick(1);


  private JoystickButton aButton= new JoystickButton(joystick1,0);
  private JoystickButton bButton= new JoystickButton(joystick1,1);
  private JoystickButton cButton= new JoystickButton(joystick1,2);
  private JoystickButton dButton= new JoystickButton(joystick1,3);

  private JoystickButton eButton= new JoystickButton(joystick1,4);
  private JoystickButton fButton= new JoystickButton(joystick1,5);

  private JoystickButton gButton= new JoystickButton(joystick1,6);

  private JoystickButton hButton= new JoystickButton(joystick1,7);
  private JoystickButton iButton= new JoystickButton(joystick1,8);

  private JoystickButton jButton= new JoystickButton(joystick1,9);
  private JoystickButton kButton= new JoystickButton(joystick1,10);

  private JoystickButton lButton= new JoystickButton(joystick1,11);
  private JoystickButton mButton= new JoystickButton(joystick1,12);

  public static XboxController firstXboxJoystick= new XboxController(13);

  public static XboxController secondXboxJoystick= new XboxController(14);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

    aButton.whenHeld(new Solenoid(true));
    bButton.whenHeld(new Solenoid(false));

    cButton.whenHeld(new Victor(true));
    dButton.whenHeld(new Victor(false));

    eButton.whenHeld(new Intake());

    fButton.whenHeld(new Output());

    gButton.whenHeld(new SecondIntake());

    hButton.whenHeld(new OpenClose(true));
    iButton.whenHeld(new OpenClose(false));

    jButton.whenHeld(new MoveIntake(true));
    kButton.whenHeld(new MoveIntake(false));

    lButton.whenHeld(new ClimbC(true));
    mButton.whenHeld(new ClimbC(false));

  }

  public Command getAutonomousCommand() {
    return null;
  }

}
