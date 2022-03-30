package March29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




class Member{

    private String userid;   
    private String username;
    private int age;         //MariaDB에서 테이블 만들때 입력한 data 중 불러오고 싶은 것 

    Member(String userid, String username, int age){ //생성자를 이용한 변수값 입력
        this.userid = userid;                        // 변수가 Private로 선언되어 있으므로 메서드를 이용하여
        this.username = username;                    // 참조를 통해 값을 입력하게 된다
        this.age = age;
    }

    static class Builder{    //빌드 패턴을 이용하기 위한 Builder class . 클래스 내부의 클래스 생성

        private String userid;   
        private String username;
        private int age;

        public Builder userid(String userid){
            this.userid = userid;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }        
        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Member build(){
            
            if(userid == null || username ==null || age == 0)
                throw new IllegalStateException("멤버클래스가 생성이 안됩니다.");
            return new Member(userid, username, age);
        }
    } // Builder class의 끝

    public String getUserid(){return userid;}
    public String getUsername(){return username;}
    public int getAge(){return age;}                // private로 선언된 변수값 얻어오기 위한 메서드

}

class MemberDTO{ 

    private String userid;   
    private String username;
    private int age;

    public String getUserid(){
        return userid;
    }

    public String getUsername(){
        return userid;
    }

    public String getAge(){
        return userid;
    }

    MemberDTO(Member member){
        this.userid = member.getUserid();
        this.username = member.getUsername();
        this.age = member.getAge();
    }
}


//==========================================================================================
public class StreamExam {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mariadb://127.0.0.1:3306/webdev"; //쓰는 방식은 규칙이니 외울것
        String userid = "webmaster";                         //
        String userpw = "1111";                              // MariaDB에서 DB를 생성할때 사용했던 정보들 입력 
        String query = "select userid, username, age from tbl_test"; //
        Connection con; // Connection
        Statement stmt; // Statement
        ResultSet rs;   // ResultSet  . 이 3개는 JDBC를 설정할때 세트로 사용됨
    
        Class.forName("org.mariadb.jdbc.Driver"); //
        con = DriverManager.getConnection(url, userid, userpw); // 내가 만든 DB와 연결
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        List<Member> list = new ArrayList<>(); ///
        List<MemberDTO> listDTO = new ArrayList<>();
    
    //==========================================================================================
        while(rs.next()){
           //list.add(new Member(rs.getString("userid"), rs.getString("username"), rs.getInt("age")));
            list.add(new Member.Builder()
                .userid(rs.getString("userid"))
                .username(rs.getString("username"))
                .age(rs.getInt("age"))
                .build()
            ); // Build 패턴을 이용하여 값을 이용하는 방식
        }
    //==========================================================================================    
        for(Member member : list ){
            System.out.println("아이디 = " + member.getUserid()
                    + ", 이름 = " + member.getUsername()
                    + ", 나이 = " + member.getAge());
        }

        listDTO = list.stream().map(MemberDTO::new).collect(Collectors.toList());
        for(MemberDTO member: listDTO){
            System.out.println("아이디 = "+ member.getUserid()+
                                ", 이름 ="+member.getUsername()+
                                ",나이 = "+ member.getAge());
        }


    //==========================================================================================
    // 종료가 되지 않았을 때 종료 시키기 위한 문구
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(con != null) con.close();
    }

}