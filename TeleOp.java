package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * TODO Created by Quest Jelinek on 9/8/2015. 
 * GitHub: TofuTheBland || https://github.com/TofuTheBland
 */
public class TeleOp extends OpMode {
    // TODO Initiate all variables
    DcMotor motor_left; //Forward Left
    DcMotor motor_right;
    Float driver_gamepad_x;
    Float driver_gamepad_y;


    @Override
    public void init() {
        // TODO Placeholder for hardware mapping, motor names may change
        motor_left = hardwareMap.dcMotor.get("motor_1");
        motor_right = hardwareMap.dcMotor.get("motor_2");


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
            motor_left.setPower(1);
            motor_right.setPower(1);


        }
        else if (driver_gamepad_y < -100)
        {
            motor_left.setPower(-1);
            motor_right.setPower(-1);
        }

        else if (driver_gamepad_x > 100)
        {
            motor_left.setPower(1);
            motor_right.setPower(-1);
        }
        else if (driver_gamepad_x < -100)
        {
            motor_left.setPower(-1);
            motor_right.setPower(1);
        }
        else
        {
            motor_left.setPower(0);
            motor_right.setPower(0);
        }

    }
}
