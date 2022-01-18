package Programmers.Kakao_2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 순위검색_효율성실패 {
    public static void main(String[] args) {
        String[] info={"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query={"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        Solution solution=new Solution();
        int[] answer=solution.solution(info,query);
        for (int i : answer) System.out.print(i+" ");
    }

    static class Solution {
        class Person {
            String language;
            String group;
            String career;
            String food;
            int score;

            Person(String language, String group, String career, String food,int score){
                this.language=language;
                this.group=group;
                this.career=career;
                this.food=food;
                this.score=score;
            }
        }

        public int[] solution(String[] info, String[] query) {
            int[] answer = {};
            answer=new int[query.length];
            List<Person> personList=new ArrayList<>();
            List<Person> queryList=new ArrayList<>();

            //리스트에 모든 지원자 정보를 삽입
            for(int i=0;i<info.length;i++){
                String[] str=info[i].split(" ");
                Person person=new Person(str[0],str[1],str[2],str[3],Integer.parseInt(str[4]));
                personList.add(person);
            }

            personList.sort(Comparator.comparingInt(p -> p.score));

            //리스트에 쿼리 목록을 삽입
            for(int i=0;i<query.length;i++){
                String[] str=query[i].split(" and ");
                String[] lastStr=str[3].split(" ");
                Person q=new Person(str[0],str[1],str[2],lastStr[0],Integer.parseInt(lastStr[1]));
                queryList.add(q);
            }

            for(int i=0;i<queryList.size();i++){
                Person wanted=queryList.get(i);

                String wLanguage=wanted.language;
                String wGroup=wanted.group;
                String wCareer=wanted.career;
                String wFood= wanted.food;
                int wScore=wanted.score;

                int index=binarySearch(personList,wScore);
                int matched=0;

                for(int p=index;p<personList.size();p++){
                    Person person=personList.get(p);
                    if(wLanguage.equals("-") || wLanguage.equals(person.language)){
                        if(wGroup.equals("-")||wGroup.equals(person.group)){
                            if(wCareer.equals("-")||wCareer.equals(person.career)){
                                if(wFood.equals("-")||wFood.equals(person.food)){
                                    matched++;
                                }
                            }
                        }
                    }
                }
                answer[i]=matched;
            }
            return answer;
        }

        private int binarySearch(List<Person> personList, int wScore) {
            int low=0;
            int high=personList.size()-1;
            int mid;

            while(low<=high){
                mid=(low+high)/2;

                if(personList.get(mid).score==wScore){
                    for(int m=mid-1;m>-1;m--){
                        if(personList.get(m).score==wScore) mid=m;
                        else break;
                    }
                    return mid;
                }
                else if(personList.get(mid).score<wScore) low=mid+1;
                else high=mid-1;
            }
            return low;
        }
    }
}
