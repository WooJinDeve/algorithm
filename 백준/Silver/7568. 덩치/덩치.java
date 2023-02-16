import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<people> peoples = new ArrayList<>();
        int n = sc.nextInt();

        for(int i = 0; i<n; i++)
            peoples.add(new people(sc.nextInt(), sc.nextInt()));

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j)
                    continue;
                if(peoples.get(i).getKg() < peoples.get(j).getKg() && peoples.get(i).getCm() < peoples.get(j).getCm()){
                    peoples.get(i).setCount();
                }
            }
        }

        for(people peo : peoples)
            System.out.print(peo.toString());

    }

    private static class people{
        private int cm;
        private int kg;
        private int count;

        public people(int cm, int kg){
            this.cm = cm;
            this.kg = kg;
            this.count = 1;
        }

        public int getKg(){
            return kg;
        }

        public int getCm(){
            return cm;
        }

        public void setCount(){
            this.count++;
        }

        @Override
        public  String toString(){
            return count + " ";
        }
    }
}