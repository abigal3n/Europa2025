package frc.robot.Subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CoralArm extends SubsystemBase{
    //motors
        //coralpivotmotor
        //wheelmotor
    public CoralArm(){

    }

    private final PIDController coralPivotPID = new PIDController(0, 0, 0);
    
    //methods
    //in
    public void intakeCoral(){
        //wheel.set(0.5)
    }

    public void releaseCoral(){
        //wheel.set(0.5)
    }

    public void pivotCoralArm(){
        //have it accept a setpoint
    }


    //out
}
