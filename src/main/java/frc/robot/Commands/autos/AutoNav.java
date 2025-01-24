package frc.robot.Commands.autos;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;

public class AutoNav extends Command{
    
    public AutoNav() {
    }

    public static Command goTo(int index){
        return AutoBuilder.pathfindToPose(Constants.WaypointConstants.mposeArray[index], Constants.AutoConstants.constantConstraints);
    }
}
