package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.ExponentialProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase{
    
    //Motor motor1 = new Motor()
    //MotoxConfig elevatorConfig;r motor2 = new Motor()
    SparkMax elevator1 = new SparkMax(0, MotorType.kBrushless);
    SparkMax elevator2 = new SparkMax(0,MotorType.kBrushless);
    // private final ExponentialProfile elevatorProfile = new ExponentialProfile(ExponentialProfile.Constraints.fromCharacteristics(0, 0, 0));
    // private ExponentialProfile.State goal = new ExponentialProfile.State(0,0);
    // private ExponentialProfile.State setpoint = new ExponentialProfile.State(0,0);
    SparkMaxConfig elevatorConfig1;
    SparkMaxConfig elevatorConfig2;

    private static double elevatorSetpoint;
    private SparkClosedLoopController elevatorController;

    public SparkMaxConfig configElevatorMotor(boolean Inverted, double kP, double kI, double kD){
            SparkMaxConfig config = new SparkMaxConfig();
                config
                .inverted(Inverted)
                .idleMode(SparkMaxConfig.IdleMode.kBrake);
                config.closedLoop
                    .pid(kP, kI, kD)
                    .outputRange(-1,1);
            return config;
        }

        public Elevator() {

            Constants.configPIDMotor(elevator1,false, 0, 0, 0);
            Constants.configPIDMotor(elevator2,false, 0, 0, 0);

            elevatorController = elevator1.getClosedLoopController();
            elevatorController.setReference(elevatorSetpoint,ControlType.kMAXMotionPositionControl);

            }
    
        //may set motors to follow eachother if there are two motors 
        public static void setElevatorLevels(double choice){
            elevatorSetpoint = choice;
        }
}


