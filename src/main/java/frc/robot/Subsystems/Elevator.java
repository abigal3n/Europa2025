package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    
    //Motor motor1 = new Motor()
    //Motor motor2 = new Motor()

    public Elevator() {

    }

    //may set motors to follow eachother if there are two motors

    @Override
    public void periodic() {
        //arm.set(-MathUtil.clamp(armPID.calculate(/* arm */arm2.getDistance()), -1, 1));
    }

   // public setElevatorLevels(int choice){
        //double elevatorSetpoint = Constants.SetpointConstants.mElevatorSetpointArray[choice];
   // }
}
