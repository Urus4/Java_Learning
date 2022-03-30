package Solo.chapter5;

class Animal{
    private String name;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Dog extends Animal{

    void sleep(){
        System.out.println(this.getName()+" zzz");
    }
}

class HouseDog extends Dog{

    HouseDog(String name){  // 이 생성자를 넣어주므로써 HouseDog의 객체를 호출할때
                            // 이름을 무조건 넣어줘야한다.
                            // 생성자가 선언된 경우 생성자의 규칙대로만 객체를 생성할 수 있다.
                            // 이 생성자로 인해 호출되는 setName()메소드가 필수적으로 실행 됨
        this.setName(name);
    }

    HouseDog(int i ){    // '생성자 오버로딩', 입력항목이 다름
        if( i == 1 ){
            this.setName("yorkshire");
        }
        else if ( i == 2 ){
            this.setName("bulldog");
        }
    }

    void sleep(){
        System.out.println(this.getName()+" zzz in house");
    }
    void sleep(int i){
        System.out.println(this.getName()+" zzz in house for " + i + "hours");
    }

}


public class InheritanceExam {
    public static void main(String[] args) {
        HouseDog housedog = new HouseDog("happy");
        HouseDog yorkshire = new HouseDog(1);
        housedog.sleep(); // Dog와 HouseDog 클래스에 각각 sleep이라는 이름을 가진 메소드를
                          // 가지고 있지만 하위클래스에 있는  sleep메소드가 높은우선순위를 가지고 있어서 호출이된다.
                          // 이것을 '메소드 오버로딩'이라 한다.
        housedog.sleep(3);
        System.out.println(housedog.getName());
        System.out.println(yorkshire.getName());

    }    
}
