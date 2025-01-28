package LeetCode;

import java.util.*;

public class Asteroid {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a:asteroids){
            while(!stack.isEmpty() && a<0 && stack.peek()>0){
                if(Math.abs(a) > stack.peek()){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(a) == stack.peek()){
                    stack.pop();
                }
                a=0;
            }
            if(a!=0){
                stack.push(a);
            }
        }

        int [] rez = new int [stack.size()];
        int i =0;
        for (int a : stack){
            rez[i++]=a;
        }

        return rez;
    }
}
