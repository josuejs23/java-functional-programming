package org.josuejs.imperative;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        // 1. Create a list of integer
        List<Integer> numbers = getIntList();
        System.out.println("numbers = " + numbers);
        // 2. Filter the even numbers
        List<Integer> evenNumbers = filterEven(numbers);
        System.out.println("evenNumbers = " + evenNumbers);
        // 3. Get a power of 2 of each number
        List<Integer> powersNumbers = powerOfTwo(evenNumbers);
        System.out.println("powersNumbers = " + powersNumbers);
        // 4. Show each number on the screen
        List<Integer> nums = showNumbers(powersNumbers);
        System.out.println("nums = " + nums);
        // 5. Get the sum of all numbers
        int total = sumOfNums(nums);
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