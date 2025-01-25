package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    
    //Motor motor1 = new Motor()
    //Motor motor2 = new Motor()
    private static double elevatorSetpoint;
    
        public Elevator() {
    
        }
    
        //may set motors to follow eachother if there are two motors
    
        @Override
        public void periodic() {
            //arm.set(-MathUtil.clamp(armPID.calculate(/* arm */arm2.getDistance()), -1, 1));
        }
    
       public static void setElevatorLevels(double choice){
            elevatorSetpoint = choice;
   }
}
