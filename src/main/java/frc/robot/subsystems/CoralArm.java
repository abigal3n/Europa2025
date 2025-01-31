package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralArm extends SubsystemBase{
    //motors
        //coralpivotmotor
        //wheelmotor
    SparkMaxConfig coralWristConfig;
    SparkMaxConfig coralWheelConfig;
    public SparkMaxConfig configCoralWrist(boolean Inverted, double kP, double kI, double kD){
            SparkMaxConfig config = new SparkMaxConfig();
                config
                .inverted(Inverted)
                .idleMode(SparkMaxConfig.IdleMode.kBrake);
                config.closedLoop
                .pid(kP, kI, kD)
                .outputRange(-1,1);
            return config;
        }
    public SparkMaxConfig configCoralWheel(boolean Inverted){
            SparkMaxConfig config = new SparkMaxConfig();
                config
                .inverted(Inverted)
                .idleMode(SparkMaxConfig.IdleMode.kBrake);
            return config;
        }
    
    private static double coralArmSetpoint;

    SparkMax coralWheel = new SparkMax(0,MotorType.kBrushless);
    SparkMax coralWrist = new SparkMax(0,MotorType.kBrushless);

        public CoralArm(){
            coralWristConfig = configCoralWrist(false, 0, 0,0);
            coralWheelConfig = configCoralWheel(true);
        }
    
        public void intakeCoral(){
            //wheel.set(0.5)
        }
    
        public void releaseCoral(){
            //wheel.set(-0.5)
        }

        public void stopCoralRoller(){
            //wheel.set(0)
        }
    
        public static void setCoralWristSetpoint(double setpoint){
            //setpoint = Constants.SetpointConstants.coralSetpointArray[index]
            coralArmSetpoint = setpoint;
        }

        public boolean hasCoral(){
        //true if has coral
        //false if not
            return true;
        }



    //out
}
