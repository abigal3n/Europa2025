package frc.robot.Subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralArm extends SubsystemBase{
    //motors
        //coralpivotmotor
        //wheelmotor
    public CoralArm(){

    }

    private final PIDController coralPivotPID = new PIDController(0, 0, 0);
   
    
    @Override
    public void periodic() {
        //coralPivotMotor.set(pivot controller. calculate)
    }
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
        //closed loop controller
        //have method to set setpoint
        
    }

    public void setCoralWristSetpoint(int index){
        //setpoint = Constants.SetpointConstants.coralSetpointArray[index]
    }

    public boolean hasCoral(){
        //true if has coral
        //false if not
        return true;
    }

    public void stopCoralRoller(){
        //wheelmotor.set(0)
    }



    //out
}
