package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class AlgaeSub extends SubsystemBase{
    //motors
    SparkMax algaeWrist = new SparkMax(0, MotorType.kBrushless);
    SparkMax algaeSpinMotor = new SparkMax(0, MotorType.kBrushless);
    private SparkClosedLoopController algaeWristController;
    // pincher1
    // pivotmotor

    static double algaeArmSetpoint;
    
        public SparkMaxConfig configAlgaeWrist(boolean Inverted, double kP, double kI, double kD){
            SparkMaxConfig config = new SparkMaxConfig();
                config
                .inverted(Inverted)
                .idleMode(SparkMaxConfig.IdleMode.kBrake);
                config.closedLoop
                .pid(kP, kI, kD)
                .outputRange(-1,1);
            return config;
        }
        public SparkMaxConfig configAlgaeMotor(boolean Inverted){
            SparkMaxConfig config = new SparkMaxConfig();
                config
                .inverted(Inverted)
                .idleMode(SparkMaxConfig.IdleMode.kBrake);
            return config;
        }


        public AlgaeSub() {
    
            SparkMaxConfig configWrist = configAlgaeWrist(true, 0,0,0);
            SparkMaxConfig configSpin = configAlgaeMotor(false);
            algaeWrist.configure(configWrist, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kNoPersistParameters);
            algaeSpinMotor.configure(configSpin, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kNoPersistParameters);
          
            algaeWristController = algaeWrist.getClosedLoopController();
            algaeWristController.setReference(algaeArmSetpoint, ControlType.kMAXMotionPositionControl);

        }
    
        //ok plan a
        //methods
        //  grab()
        //      pincher1.set(0.5)
        //      pincher2.set(0.5)
        public void grab(){
            algaeSpinMotor.set(0.5);
        }
        //grab for amount of time or until we have an algae
        //thatll be in commands though
        public void release(){
            algaeSpinMotor.set(-0.5);
        }
        //
        public void stop(){
            algaeSpinMotor.set(0);
        }
    
        public static void setAlgaeSetpoint(double setpoint){
            algaeArmSetpoint = setpoint;
        }

        public boolean hasAlgae(){
            //if sensor detects algae
                //return true
            //if sensor doesnt detect algae
                //return false
            return true;
        }
    //  release()
    //      pincher2.set(-0.5)
    //      pincher1.set(-0.5)
    //  stop()
    //      pincher1.set(0)
    //      pincher2.set(0)

}
