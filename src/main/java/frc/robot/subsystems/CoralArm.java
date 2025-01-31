package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
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
    SparkClosedLoopController coralWristController;

    //sensor coralSensor = new Sensor();
    
    private static double coralArmSetpoint;

    SparkMax coralWheel = new SparkMax(0,MotorType.kBrushless);
    SparkMax coralWrist = new SparkMax(0,MotorType.kBrushless);

        public CoralArm(){
            Constants.configPIDMotor(coralWrist, false, 0, 0,0);
            Constants.configMotor(coralWheel, true);

            coralWristController = coralWrist.getClosedLoopController();
            coralWristController.setReference(coralArmSetpoint,ControlType.kMAXMotionPositionControl);
        }
    
        public void intakeCoral(){
            coralWheel.set(0.5);
        }
    
        public void releaseCoral(){
            coralWheel.set(-0.5);
        }

        public void stopCoralRoller(){
            coralWheel.set(0);
        }
    
        public static void setCoralWristSetpoint(double setpoint){
            coralArmSetpoint = setpoint;
        }

        public boolean hasCoral(){
        //true if has coral
        //false if not
            return true;
        }



    //out
}
