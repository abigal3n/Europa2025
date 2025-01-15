package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.CoralArm;

public class DefaultCoral extends Command{
    private Joystick primaryJoystick = new Joystick(0);
    private XboxController secondController = new XboxController(1);
    CoralArm coralArm;

    public DefaultCoral(CoralArm coralArm, Joystick primaryJoystick, XboxController secondController){
        addRequirements(coralArm);
        this.primaryJoystick = primaryJoystick;
        this.coralArm = coralArm;
        this.secondController = secondController;
    }

    //what is the meaning of this

    //methods
        //when get some button
            //intake coral
        //when get other button
            //release coral
        //when get some joystick
            //have it pivot the arm
        
}
