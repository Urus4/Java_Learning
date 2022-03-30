package Solo.chapter5;

class Food{

    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Rice extends Food{

}

class Kimchi extends Food{

}

public class IS_A {
    public static void main(String[] args) {
        
        //Food food = new Rice(); // Rice 클래스는 Food 클래스를 상속, Rice는 Food 클래스의 하위 개념
                                // 이런 경우 Rice는 Food에 포함되기 때문에 "밥은 음식이다"라고 표현 할 수 있다.
                                // 따라서 좌측과 같이 자식클래스의 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.
                                // 그런데 주의해야 할 점은
                                // 이때 Rice클래스에만 존재하는 메소드를 사용할 수 없다.
                                // 오직 Food클래스의 메소드만 사용가능하다.(자료형을 부모클래스로 했기 때문에)

        //Rice rice = new Food(); // 위 코드와 반대로 쓰게 되면
                                  // 에러가 발생한다. 
                                  // 개념적으로 읽어보면 '음식은 밥이다.'로 읽을 수 있는데
                                  // 음식으로 만든 객체는 '김치'도 될 수 있지 않은가?

        Rice rice = new Rice();
        rice.setName("잡곡밥");
        System.out.println(rice.getName());
    

    }
}
