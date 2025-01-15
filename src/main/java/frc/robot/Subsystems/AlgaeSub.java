package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AlgaeSub extends SubsystemBase{
    //motors
    // pincher1
    // pincher2
    // pivotmotor

    public AlgaeSub() {
        //pincher2.setInverted();
    }

    //ok plan
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
    //  release()
    //      pincher2.set(-0.5)
    //      pincher1.set(-0.5)
    //  stop()
    //      pincher1.set(0)
    //      pincher2,set(0)

}
