package Solo.chapter5;

class Method01 {

    int sum(int a, int b){ // 입력 X, 출력 O
        return a+b;
    }

    void shout1(){  // 입력 X, 출력 X
        System.out.println("와");
    }

    int shout2(){ // 입력 X, 출력 O
        return 10;
    }

    void shout3(int a,int b){ // 입력 O, 출력 X
        System.out.println(a+b);
    }

}




public class Method {
    public static void main(String[] args) {
        
        int a=0;
        int b=0;

        Method01 method = new Method01();
        a = method.sum(10, 3);
        System.out.println(a);

        method.shout1();

        b= method.shout2();
        System.out.println(b);

        method.shout3(2,5);

    }

}
