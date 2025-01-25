package frc.robot.subsystems;

import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSub extends SubsystemBase{
    //this is the climb system :0
    //idek man
    //guy waas here

    //Motor pushArm = new Motor();


    public SparkMaxConfig configClimbMotor(boolean Inverted){
        SparkMaxConfig config = new SparkMaxConfig();
            config
            .inverted(Inverted)
            .idleMode(SparkMaxConfig.IdleMode.kBrake);

        return config;
    }
    
    public ClimbSub(){
        SparkMaxConfig climbConfig = configClimbMotor(false);
        //pushArm.configure(climbConfig, SparkMax.ResetMode.kResetSafeParameter, SparkMax.PersistMode.kNoPersistParameters)
    }

    //i wonder still
    //we could have it push down until it reaches a setpoint
    //or have the pull up initiated as the driver presses a button then have it freeze in place when not being moved
    //that way the drivers can tell it when to stop
}