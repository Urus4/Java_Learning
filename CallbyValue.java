package Solo.chapter5;

class Updater{
    void update(Counter counter){ // 메서드가 입력받는 값이 '객체'
  //void update(int count){
        counter.count++;
    }
}

class Counter{
    int count = 0;
}


public class CallbyValue {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);
        
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter); // 메서드의 입력값으로 객체를 입력 받으면
                                     // 메소드가 입력받은 객체를 그대로 사용하기 때문에 메소드가 객체의 속성값을 변경하면
                                     // 메소드 수행 후에도 객체의 변경된 속성값이 유지된다.
        //myUpdater.update(myCounter.count); // Updater클래스의 update메서드의 입력이 값(int 자료형, 변수 그 자체가 아닌 그 변수가 저장하고 있는 값)을 전달받았기 때문에
                                           // 메서드의 return 값도 없고 저장하는 변수도 없기 때문에 단순히 연산만 처리되고 변화한 값은 저장되지 않을 것이다.
        System.out.println("after update:"+myCounter.count);
    
    }
}
