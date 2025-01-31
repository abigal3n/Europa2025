// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;
import java.util.List;

import com.pathplanner.lib.path.PathConstraints;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.sds.ModuleConfiguration;
import frc.robot.sds.SdsModuleConfigurations;
import frc.robot.subsystems.CoralArm;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static final class AutoConstants {
    public static double kPYController = 3;
    public static double kPXController = 3;
    public static double kPThetaController = 1;
    public static double kMaxSpeedMetersPerSecond = DriveConstants.MaxVelocityMetersPerSecond * .50;
    public static double kMaxAccelerationMetersPerSecondSquared = 4;
    public static Constraints kThetaControllerConstraints = new Constraints(
        DriveConstants.MaxAngularVelocityRadiansPerSecond * .5, (Math.PI * 2) / 2);

    public static PathConstraints constantConstraints = new PathConstraints(2.5, 2, 2.5 * Math.PI, 3 * Math.PI);

  }

  public static final ModuleConfiguration ModuleType = SdsModuleConfigurations.MK4I_L1;

  
  public static void configPIDMotor(SparkMax motor, boolean Inverted, double kP, double kI, double kD){
        SparkMaxConfig config = new SparkMaxConfig();
            config
            .inverted(Inverted)
            .idleMode(SparkMaxConfig.IdleMode.kBrake);
            config.closedLoop
            .pid(kP, kI, kD)
            .outputRange(-1,1);
        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }
  public static void configMotor(SparkMax motor, boolean Inverted){
      SparkMaxConfig config = new SparkMaxConfig();
          config
          .inverted(Inverted)
          .idleMode(SparkMaxConfig.IdleMode.kBrake);
      motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  public static final class DriveConstants {
    public static final double kDrivePeriod = TimedRobot.kDefaultPeriod;

    // Distance between left and right wheels
    public static final double kTrackWidthMeters = 0.6223 / 2;
    // Distance between front and back wheels
    public static final double kTrackBaseMeters = 0.40004999999999996 / 2;

    private static final Translation2d kFrontLeftLocation = new Translation2d(kTrackBaseMeters, kTrackWidthMeters);
    private static final Translation2d kFrontRightLocation = new Translation2d(kTrackBaseMeters, -kTrackWidthMeters);
    private static final Translation2d kBackLeftLocation = new Translation2d(-kTrackBaseMeters, kTrackWidthMeters);
    private static final Translation2d kBackRightLocation = new Translation2d(-kTrackBaseMeters, -kTrackWidthMeters);

    public static final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        kFrontLeftLocation, kFrontRightLocation, kBackLeftLocation, kBackRightLocation);

    // FIXME Measure the drivetrain's maximum velocity or calculate the theoretical.
    // The formula for calculating the theoretical maximum velocity is:
    // <Motor free speed RPM> / 60 * <Drive reduction> * <Wheel diameter meters> *
    // pi
    // By default this value is setup for a Mk3 standard module using Falcon500s to
    // drive.
    // An example of this constant for a Mk4 L2 module with NEOs to drive is:
    // 5880.0 / 60.0 / SdsModuleConfigurations.MK4_L2.getDriveReduction() *
    // SdsModuleConfigurations.MK4_L2.getWheelDiameter() * Math.PI
    /**
     * The maximum velocity of the robot in meters per second.
     * <p>
     * This is a measure of how fast the robot should be able to drive in a straight
     * line.
     */
    public static final double kNeoFreeSpinRpm = 5676;
    public static final double MaxVelocityMetersPerSecond = (kNeoFreeSpinRpm / 60.0) *
        ModuleType.getDriveReduction() *
        ModuleType.getWheelDiameter() * Math.PI;

    public static final double MaxAngularVelocityRadiansPerSecond = MaxVelocityMetersPerSecond
        / Math.hypot(kTrackWidthMeters / 2, kTrackBaseMeters / 2) * .75;

  }

  public static final class ModuleConstants {

    public static final double MaxModuleAngularSpeedRadiansPerSecond = 2 *
        Math.PI;
    public static final double MaxModuleAngularAccelerationRadiansPerSecondSquared = 2 * Math.PI;

    // public static final int kEncoderCPR = 1024;
    // public static final double kWheelDiameterMeters = 0.15;
    // public static final double kDriveEncoderDistancePerPulse =
    // // Assumes the encoders are directly mounted on the wheel shafts
    // (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;

    // public static final double kTurningEncoderDistancePerPulse =
    // // Assumes the encoders are on a 1:1 reduction with the module shaft.
    // (2 * Math.PI) / (double) kEncoderCPR;
    public static final double TurningEncoderDegreesPerPulse = Math
        .toDegrees(2. * Math.PI * ModuleType.getSteerReduction());

    // public static final double kPModuleTurningController = 1;

    // public static final double kPModuleDriveController = 1;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class WaypointConstants {

    static Pose2d CoralStationLeft = new Pose2d(11.5, 6.5, new Rotation2d(125));
    static Pose2d CoralStationRight = new Pose2d(2, 1.7, new Rotation2d(-125));
    static Pose2d ReefN = new Pose2d(6.3, 4.1, new Rotation2d(125));
    static Pose2d ReefS = new Pose2d(2.7, 4.1, new Rotation2d(-125));
    static Pose2d ReefSE = new Pose2d(3.6, 2.5, new Rotation2d(58));
    static Pose2d ReefSW = new Pose2d(3.6, 5.67, new Rotation2d(-58));
    static Pose2d ReefNE = new Pose2d(5.5, 2.4, new Rotation2d(-122));
    static Pose2d ReefNW = new Pose2d(5.5, 5.8, new Rotation2d(122));
    static Pose2d Processor = new Pose2d(6.35, 1.55, new Rotation2d(-90));

    public static Pose2d[] mposeArray = { CoralStationLeft, CoralStationRight, ReefN, ReefS, ReefSE, ReefSW, ReefNE,
        ReefNW, Processor };

  }

  public static final class SetpointConstants {
    // here is where we keep all the setpoints for the subsystem pid

    public class ElevatorSetpoints {
      static double l1 = 0;
      static double l2 = 0;
      static double l3 = 0;
      static double l4 = 0;

      static double groundLevel = 0;
      static double algaeLow = 0;
      static double algaeHigh = 0;


    }
    // lowest level
    // L1
    // L2
    // L3
    // L4
    // public double[] mElevatorSetpointArray = {setpoints}

    public class CoralPivotAngles {
      // angle of release
      static double l1 = 0; //reef l1
      static double lmid = 0; //reef l2 and l3
      static double l4 = 0; //reef l4
      static double CoralSt = 0; //pointing up to recieve coral from hp
      static double up = 0; //out of the way for intaking algae
    }

    public class XOffset {
      static double l1 = 0;
      static double left = 0;
      static double right = 0;
      static double none = 0;
      static double CoralSt = 0;
    }

    public class YOffset {
      static double l1 = 0;
      static double Reef = 0;
      static double CoralSt = 0;
      static double Algae = 0;
    }

    public class RotOffset {
      static double l1 = 0;
      static double none = 0;
      static double CoralSt = 0;
    }

    public class AlgaeArmAngles {
      static double up = 0; //hold algae in
      static double down = 0; //intake or outtake algae
    }
    // L2 and L3 Angle
    // L4 Angle
    // Hold angle
    // grab angle? like where it will be when grabbing coral from the station
    // public double[] mCoralSetpointArray = {setpoints}

    // Algae Angles
    // angle for grabbing and releasing algae
    // angle for holding Algae
    public class OptionArrays {

      public class ConfigOption {

        public double algaeAngle;
        public double coralAngle;
        public double elevatorSetpoint;

        public ConfigOption(double coralAngle, double elevatorSetpoint, double algaeAngle) {

          this.coralAngle = coralAngle;
          this.elevatorSetpoint = elevatorSetpoint;
          this.algaeAngle = algaeAngle;

        }

      }

      //reef
      public ConfigOption l1 = new ConfigOption(CoralPivotAngles.l1, ElevatorSetpoints.l1, AlgaeArmAngles.up);
      public ConfigOption l2Left = new ConfigOption(CoralPivotAngles.lmid, ElevatorSetpoints.l2, AlgaeArmAngles.up);
      public ConfigOption l3Left = new ConfigOption(CoralPivotAngles.lmid, ElevatorSetpoints.l3, AlgaeArmAngles.up);
      public ConfigOption l4Left = new ConfigOption(CoralPivotAngles.l4, ElevatorSetpoints.l4, AlgaeArmAngles.up);
      public ConfigOption l2Right = new ConfigOption(CoralPivotAngles.lmid, ElevatorSetpoints.l2, AlgaeArmAngles.up);
      public ConfigOption l3Right = new ConfigOption(CoralPivotAngles.lmid, ElevatorSetpoints.l3, AlgaeArmAngles.up);
      public ConfigOption l4Right = new ConfigOption(CoralPivotAngles.l4, ElevatorSetpoints.l4, AlgaeArmAngles.up);
      public ConfigOption AlgaeLow = new ConfigOption(CoralPivotAngles.up, ElevatorSetpoints.algaeLow, AlgaeArmAngles.down);
      public ConfigOption AlgaeHigh = new ConfigOption(CoralPivotAngles.up, ElevatorSetpoints.algaeHigh, AlgaeArmAngles.down);
      public ConfigOption AlgaeGround = new ConfigOption(CoralPivotAngles.up, ElevatorSetpoints.groundLevel, AlgaeArmAngles.down);

      //different spots
      public ConfigOption CoralStation = new ConfigOption(CoralPivotAngles.CoralSt, ElevatorSetpoints.l2, AlgaeArmAngles.up);
      public ConfigOption Processor = new ConfigOption(CoralPivotAngles.up, ElevatorSetpoints.groundLevel, AlgaeArmAngles.down);

      //to hold everything in while sitting there
      public ConfigOption driveConfig = new ConfigOption(CoralPivotAngles.l4, ElevatorSetpoints.groundLevel, AlgaeArmAngles.up);
      
      // public static double[] l1 = { CoralPivotAngles.l1, ElevatorSetpoints.l1,
      // XOffset.l1, YOffset.l1, RotOffset.l1,

      // AlgaeArmAngles.down };
      // public static double[] l2Left = { CoralPivotAngles.lmid, ElevatorSetpoints.l2,
      // XOffset.left, YOffset.Reef,
      // RotOffset.none, AlgaeArmAngles.down };
      // public static double[] l3Left = { CoralPivotAngles.lmid, ElevatorSetpoints.l3, XOffset.left, YOffset.Reef,
      //     RotOffset.none, AlgaeArmAngles.down };
      // public static double[] l4Left = { CoralPivotAngles.l4, ElevatorSetpoints.l4, XOffset.left, YOffset.Reef,
      //     RotOffset.none, AlgaeArmAngles.down };
      // public static double[] l2Right = { CoralPivotAngles.lmid, ElevatorSetpoints.l2, XOffset.right, YOffset.Reef,
      //     RotOffset.none, AlgaeArmAngles.down };
      // public static double[] l3Right = { CoralPivotAngles.lmid, ElevatorSetpoints.l3, XOffset.right, YOffset.Reef,
      //     RotOffset.none, AlgaeArmAngles.down };
      // public static double[] l4Right = { CoralPivotAngles.l4, ElevatorSetpoints.l4, XOffset.right, YOffset.Reef,
      //     RotOffset.none, AlgaeArmAngles.down };
      // public static double[] CoralStation = { CoralPivotAngles.CoralSt, ElevatorSetpoints.l2, XOffset.CoralSt,
      //     YOffset.CoralSt, RotOffset.none, AlgaeArmAngles.down };
      // public static double[] Processor = { CoralPivotAngles.Out, ElevatorSetpoints.groundLevel, XOffset.none,
      //     YOffset.Algae, RotOffset.none, AlgaeArmAngles.up };
      // public static double[] AlgaeLow = { CoralPivotAngles.Out, ElevatorSetpoints.l3, XOffset.none, YOffset.Algae,
      //     RotOffset.none, AlgaeArmAngles.up };
      // public static double[] AlgaeHigh = { CoralPivotAngles.Out, ElevatorSetpoints.l4, XOffset.none, YOffset.Algae,
      //     RotOffset.none, AlgaeArmAngles.up };

      List<ConfigOption> positionList = new ArrayList<ConfigOption>();

      OptionArrays() {
        positionList.add(l1); // 0
        positionList.add(l2Left); // 1
        positionList.add(l3Left); // 2
        positionList.add(l4Left); // 3
        positionList.add(l2Right);// 4
        positionList.add(l3Right);// 5
        positionList.add(l4Right);// 6
        positionList.add(CoralStation); // 7
        positionList.add(Processor); // 8
        positionList.add(AlgaeLow); // 9
        positionList.add(AlgaeHigh); // 10

      }

    }

  }

}
