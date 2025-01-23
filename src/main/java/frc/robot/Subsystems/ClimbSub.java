package frc.robot.Subsystems;

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

    
}