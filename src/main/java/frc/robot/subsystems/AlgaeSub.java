package frc.robot.subsystems;

import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AlgaeSub extends SubsystemBase{
    //motors
    // pincher1
    // pincher2
    // pivotmotor
    double algaeArmSetpoint;

    public SparkMaxConfig configAlgaeMotor(boolean Inverted){
        SparkMaxConfig config = new SparkMaxConfig();
            config
            .inverted(Inverted)
            .idleMode(SparkMaxConfig.IdleMode.kBrake);

        return config;
    }
    
    public AlgaeSub() {

        SparkMaxConfig configOne = configAlgaeMotor(true);
        SparkMaxConfig configTwo = configAlgaeMotor(false);

        //pincher1.configure(configOne, SparkMax.ResetMode.kResetSafeParameter, SparkMax.PersistMode.kNoPersistParameters)
        //pincher2.configure(configTwo, SparkMax.ResetMode.KResetSafeParameter, SparkMAx.PersistMode.kNoPersistParameters)
      
    }

    //ok plan a
    //methods
    //  grab()
    //      pincher1.set(0.5)
    //      pincher2.set(0.5)
    public void grab(){
        // pincher1.set(0.5);
        // pincher2.set(0.5);
    }
    //grab for amount of time or until we have an algae
    //thatll be in commands though

    public void release(){
        // pinch1.set(-0.5)
        // pinch2.set(-0.5)
    }
    //
    public void stop(){
        // pinch1.set(0)
        // pinch2.set(0)
    }

    public void tilt(){
        //have the joystick inputs change the setpoint of the pivot motor
        //may require pivot pid
    }

    public void setAlgaeSetpoint(double setpoint){
        algaeArmSetpoint = setpoint;
    }
    //  release()
    //      pincher2.set(-0.5)
    //      pincher1.set(-0.5)
    //  stop()
    //      pincher1.set(0)
    //      pincher2.set(0)

}
