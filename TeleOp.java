package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * TODO Created by Quest Jelinek on 10/13/2015.
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
        motor_left = hardwareMap.dcMotor.get("motor_1");
        motor_right = hardwareMap.dcMotor.get("motor_2");

        //Added this for the lads
        driver_gamepad_x = gamepad1.left_stick_x;
        driver_gamepad_y = gamepad1.left_stick_y;
    }

    public void forward() {
        //For the method .setPower() pass a value from -1 to 1 (inc. 0)
        motor_left.setPower(1);
        motor_right.setPower(1);
    }
    public void backward() {
        //For the method .setPower() pass a value from -1 to 1 (inc. 0)
        motor_left.setPower(-1);
        motor_right.setPower(-1);
    }
    public void left() {
        //For the method .setPower() pass a value from -1 to 1 (inc. 0)
        motor_left.setPower(1);
        motor_right.setPower(-1);
    }

    public void right(){
        motor_left.setPower(-1);
        motor_left.setPower(1);
    }

    @Override
    public void loop() {

        if(driver_gamepad_y > 100) {forward();}
        else if (driver_gamepad_y < -100) {backward();}
        else if (driver_gamepad_x > 100) {left();}
        else if (driver_gamepad_x < -100) {right();}
        else {
            motor_left.setPower(0);
            motor_right.setPower(0);
        }
    }
}

//TODO Add a separate library for movement functions and add smoothing function
