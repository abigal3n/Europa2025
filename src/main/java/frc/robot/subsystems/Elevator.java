package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.ExponentialProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    
    //Motor motor1 = new Motor()
    //Motor motor2 = new Motor()
    SparkMax motor1 = new SparkMax(0, MotorType.kBrushless);
    // private final ExponentialProfile elevatorProfile = new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(0, 0, 0));
    // private ExponentialProfile.State goal = new ExponentialProfile.State(0,0);
    // private ExponentialProfile.State setpoint = new ExponentialProfile.State(0,0);
    

    private static double elevatorSetpoint;
    
        public Elevator() {

            motor1.getClosedLoopController().setReference(elevatorSetpoint,ControlType.kMAXMotionPositionControl);
            // elevatorPID = new ProfiledPIDController(elevatorSetpoint, elevatorSetpoint, elevatorSetpoint, new ExponentialProfile.Constraints.fromCharacteristics(0.02, elevatorSetpoint, elevatorSetpoint));
            
        }
    
        //may set motors to follow eachother if there are two motors
        

        
    
        public static void setElevatorLevels(double choice){
            elevatorSetpoint = choice;
        }
}


