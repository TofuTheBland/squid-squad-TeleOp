package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * TODO Created by Quest Jelinek on 9/8/2015.
 * GitHub: TofuTheBland || https://github.com/TofuTheBland
 */
public class TeleOp extends OpMode {
    // TODO Initiate all variables
    DcMotor motor_leftFront; //Forward Left
    DcMotor motor_rightFront;
    DcMotor motor_leftBack; //Backward Left
    DcMotor motor_rightBack;
    Float driver_gamepad_x;
    Float driver_gamepad_y;


    @Override
    public void init() {
        // TODO Placeholder for hardware mapping, motor names may change
        motor_leftFront = hardwareMap.dcMotor.get("motor_1");
        motor_rightFront = hardwareMap.dcMotor.get("motor_2");
        motor_leftFront = hardwareMap.dcMotor.get("motor_3");
        motor_rightFront = hardwareMap.dcMotor.get("motor_4");

        //Added this for the lads
        driver_gamepad_x = gamepad1.left_stick_x;
        driver_gamepad_y = gamepad1.left_stick_y;
    }

    @Override
    public void loop() {

        // TODO Example method/action of the motor, in this case applying power


        if(driver_gamepad_y > 100)
        {
            //For the method .setPower() pass a value from -1 to 1 (inc. 0)
            motor_leftFront.setPower(1);
            motor_leftBack.setPower(1);
            motor_rightFront.setPower(1);
            motor_rightBack.setPower(1);

        }
        else if (driver_gamepad_y < -100)
        {
            motor_leftFront.setPower(-1);
            motor_leftBack.setPower(-1);
            motor_rightBack.setPower(-1);
            motor_rightFront.setPower(-1);
        }

        else if (driver_gamepad_x > 100)
        {
            motor_leftFront.setPower(1);
            motor_leftBack.setPower(1);
            motor_rightFront.setPower(-1);
            motor_rightBack.setPower(-1);
        }
        else if (driver_gamepad_x < -100)
        {
            motor_leftFront.setPower(-1);
            motor_leftBack.setPower(-1);
            motor_rightFront.setPower(1);
            motor_rightBack.setPower(1);
        }
        else
        {
            motor_leftFront.setPower(0);
            motor_leftBack.setPower(0);
            motor_rightFront.setPower(0);
            motor_rightBack.setPower(0);
        }

    }
}
