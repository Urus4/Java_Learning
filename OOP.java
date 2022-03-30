package Solo.chapter5;

class Calculator{
    static int result =0; // 이전에 계산한 결과값을 저장하기 위해 static으로 사용

    int add(int num){          // num이 메서드 안에서 선언되고 초기화 되었으므로 메서드 안에서만 살아있다(지역변수)
        result = result + num;
        return result;
    }

    int sub(int num){
        result = result - num;
        return result;
    }
}

public class OOP{
    public static void main(String[] args){
        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();
             
        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));
    
        System.out.println(cal2.sub(5));
        System.out.println(cal2.sub(7));
    
    }
}