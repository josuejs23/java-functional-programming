package org.josuejs.v2_superfunctions_classes;
import org.josuejs.v2_superfunctions_classes.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        // 1. Create a list of integer
        List<Integer> numbers = Superfunctions.provide(3, new Naturals());
        System.out.println("numbers = " + numbers);

        // 2.a Filter the even numbers
        List<Integer> filters = Superfunctions.filter(numbers, new JustEvens());
        System.out.println("filters = " + filters);
        // 3. Get a power of 2 of each number
        List<Integer> transformed = Superfunctions.transform(filters, new Squared());
        System.out.println("transformed = " + transformed);
        // 4a. Show each number on the screen and return the list
        List<Integer> nums = Superfunctions.act(transformed, new Printer());
        System.out.println("nums = " + nums);

        // 4b. Show each number on the screen
        Superfunctions.consume(transformed, new Printer());

        // 5. Get the sum of all numbers
        int total = Superfunctions.reduce(transformed, 0, new Sum());
        System.out.println("total = " + total);
    }

    private List<Integer> getIntList(){
        return List.of(1,2,3,4,5,6,7,8,9,10);
    }

    private List<Integer> filterEven(List<Integer> nums){
        List<Integer> evenNumbers = new ArrayList<>();
        for(Integer num : nums){
            if( num % 2 == 0 ) evenNumbers.add(num);
        }
        return evenNumbers;
    }
    
    private List<Integer> powerOfTwo(List<Integer> nums){
        List<Integer> numbers = new ArrayList<>();
        for(Integer num : nums){
            numbers.add( num * num);
        }
        return numbers;
    }

    private List<Integer> showNumbers(List<Integer> nums){
        for(Integer num : nums){
            System.out.print("Num => " + num + "\n");
        }
        return nums;
    }
    
    private int sumOfNums(List<Integer> nums){
        int total = 0;
        for( Integer num : nums){
            total += num;
        }
        return  total;
    }
}