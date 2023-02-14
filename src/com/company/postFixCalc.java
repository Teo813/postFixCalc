package com.company;
import java.util.Scanner;
import java.util.Stack;
public class postFixCalc {
    public static void main(String[] args) {
        Stack calcStack = new Stack();
        boolean operator = false;
        int countNum = 0;
        String currentNumber = "";
        int rightNum,leftNum;
        Scanner src = new Scanner(System.in);
        System.out.println("Please input a post fix problem");
        String inEq = src.nextLine();
        //check current symbol
        for (int n = 0; n<inEq.length();n++){
            if (Character.isDigit(inEq.charAt(n))){
                currentNumber=currentNumber+inEq.charAt(n);
            } else if(inEq.charAt(n)== ' '){
                if (currentNumber.length()!=0){
                    calcStack.push(Integer.parseInt(currentNumber));
                    countNum++;
                }
                currentNumber = "";
            }
            //run division
            else if(inEq.charAt(n) == '/' && countNum>1){
                rightNum = (int)calcStack.pop();
                leftNum = (int)calcStack.pop();
                calcStack.push(leftNum/rightNum);
                operator = true;
                countNum--;
            }
            //run multiplication
            else if(inEq.charAt(n) == '*' && countNum>1){
                rightNum = (int)calcStack.pop();
                leftNum = (int)calcStack.pop();
                calcStack.push(leftNum*rightNum);
                operator = true;
                countNum--;
            }
            //Run addition
            else if(inEq.charAt(n) == '+' && countNum>1){
                rightNum = (int)calcStack.pop();
                leftNum = (int)calcStack.pop();
                calcStack.push(leftNum+rightNum);
                operator = true;
                countNum--;
            }
            //run subtraction
            else if(inEq.charAt(n) == '-'&& countNum>1){
                rightNum = (int)calcStack.pop();
                leftNum = (int)calcStack.pop();
                calcStack.push(leftNum-rightNum);
                operator = true;
                countNum--;
            }
        }
        System.out.println("Final result = " + calcStack.pop());
    }
}
