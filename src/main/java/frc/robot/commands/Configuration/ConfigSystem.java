package frc.robot.commands.Configuration;

import java.util.List;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.SetpointConstants.OptionArrays;
import frc.robot.subsystems.AlgaeSub;
import frc.robot.subsystems.CoralArm;
import frc.robot.subsystems.Elevator;

public class ConfigSystem extends Command {

    int choice;
    List<double[]> positionList;

    CoralArm coralArm;
    Elevator elevatorSub;
    AlgaeSub algaeSub;

    public ConfigSystem(List<double[]> positionList, CoralArm coralArm, Elevator elevatorSub, AlgaeSub algaeSub) {

        addRequirements(coralArm);
        addRequirements(elevatorSub);
        addRequirements(algaeSub);

        this.positionList = positionList;
        this.coralArm = coralArm;
        this.elevatorSub = elevatorSub;
        this.algaeSub = algaeSub;

    }

    public void Configure(int choice) {
        double[] optionArray = positionList.get(choice);

        CoralArm.setCoralWristSetpoint(optionArray[0]);
        Elevator.setElevatorLevels(optionArray[1]);
        //aprilTagAlign.setXOffset(optionArray[2]);
        //aprilTagAlign.setYOffset(optionArray[3]);
        //aprilTagAlign.setRotOffset(optionArray[4]);
        AlgaeSub.setAlgaeSetpoint(optionArray[5]);

    }
    // option array has (coralSetpoint, elevatorSetpoint, xOffset, yOffset,
    // rotOffset, algaeSetpoint)

}
