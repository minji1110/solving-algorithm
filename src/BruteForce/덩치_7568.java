package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {

        class Person{
            int weight;
            int height;
            int rate;

            public Person(int weight,int height){
                this.weight=weight;
                this.height=height;
                rate=1;
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int peopleNum=Integer.parseInt(reader.readLine());

        List<Person> people=new ArrayList<>();

        for(int i=0;i<peopleNum;i++){
            String[] wh=reader.readLine().split(" ");
            int weight=Integer.parseInt(wh[0]);
            int height=Integer.parseInt(wh[1]);

            people.add(new Person(weight,height));
        }

        for (Person person : people) {
            for (Person otherPerson : people) {
                if(otherPerson.weight>person.weight && otherPerson.height>person.height)
                    person.rate+=1;
            }
            System.out.print(person.rate+" ");
        }
        reader.close();
    }
}
