package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Drive extends SubsystemBase {

  private static Drive instance = null;
  private CANSparkMax sparkMaxFrontRight ;
  private CANSparkMax sparkMaxBackRight ;
  private CANSparkMax sparkMaxFrontLeft;
  private CANSparkMax sparkMaxBackLeft;

  public Drive() {
        
    sparkMaxFrontRight=new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
    sparkMaxFrontLeft=new CANSparkMax(2, CANSparkMax.MotorType.kBrushless);
    sparkMaxBackRight=new CANSparkMax(3, CANSparkMax.MotorType.kBrushless);
    sparkMaxBackLeft= new CANSparkMax(4, CANSparkMax.MotorType.kBrushless);

    sparkMaxBackRight.follow(sparkMaxFrontRight);
    sparkMaxBackLeft.follow(sparkMaxFrontLeft);
  
  }

  public void setRight(double rightPower){
    sparkMaxFrontRight.set(rightPower);
  }

  public void setLeft(double leftPower){
    sparkMaxFrontLeft.set(leftPower);
  }

  public static Drive getInstance() {
    if (instance== null){
      instance= new Drive();
    }
    return instance;
  }

  public void periodic() {
    SmartDashboard.putNumber("rightSpeed", sparkMaxFrontRight.get());
    SmartDashboard.putNumber("leftSpeed", sparkMaxFrontLeft.get());
  }

}

