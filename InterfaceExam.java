package Solo.chapter5;

abstract class Predator extends Animal1{
    abstract String getFood();  //abstract로 생성된 메서드도
                                //실행부와 마찬가지로 실행부가 없다

    void printFood(){   // abstract 클래스는 interface와는 달리 default, static 선언을 하지 않아도 메서드 생성 가능
        System.out.printf("my food is %s\n",getFood()); 
    }

    static int LEG_COUNT =4; 
    static int speed(){
        return LEG_COUNT * 30;
    }
}

interface Barkable{
    void bark();
}


class Animal1{
    private String name;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Tiger extends Predator implements Barkable {
    @Override
    public String getFood(){
            return "apple";
    }

    @Override
    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Predator implements Barkable{
    @Override
    public String getFood(){
         return "banana";
    }

    @Override
    public void bark() {
        System.out.println("으르렁");
    }
}


class ZooKeeper{

    public void feed(Predator predator){ 
        System.out.println("feed "+predator.getFood());
    }   
}

/*
class Bouncer{
    void barkAnimal(Animal1 animal){       //barkAnimal의 입력자료형은 Tiger나 Lion이 아닌 Animal
        if(animal instanceof Tiger){       //하지만 이 메소드를 호출할때 tiger, lion 객체를 전달 할 수 있다
            System.out.println("어흥");     // 왜냐하면 Tiger와 Lion 클래스가 Animal클래스를 상속한 자식클래스이기 때문이다.
        }else if(animal instanceof Lion){   // 자식클래스에 의해서 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수 있다
            System.out.println("으르렁");
        }
    }// instanceof : 어떤 객체가 특정 클래스의 객체인지를 조사할때 사용하는 명령어
}
*/
class Bouncer{
    void barkAnimal(Barkable animal){       //barkAnimal의 입력자료형은 Tiger나 Lion이 아닌 Animal
        animal.bark();
    }
}

public class InterfaceExam {
    public static void main(String[] args) {

        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();

        bouncer. barkAnimal(tiger);
        bouncer. barkAnimal(lion);

    }    
}
