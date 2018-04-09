import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point{
    int x;
    int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public long findDistance(Point p){
        return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String>  result = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            Point[] points = new Point[4];
            for(int j = 0 ; j< 4 ; j++){
                Point point = new Point();
                point.setX(sc.nextInt());
                points[j] = point;
            }

            for(int j = 0 ; j<4 ; j++){
                points[j].setY(sc.nextInt());
            }

            ArrayList<Long> distance = new ArrayList<>(6);
            for(int j=0; j<4 ; j++){
                for(int k=j+1; k<4 ; k++){
                    distance.add(points[j].findDistance(points[k]));
                }
            }
            Collections.sort(distance);
//            for(Long l : distance)
//                System.out.println(l.longValue());
            if(distance.get(0).longValue() == distance.get(1).longValue() && distance.get(1) == distance.get(2).longValue() &&
                    distance.get(2).longValue() == distance.get(3).longValue() && distance.get(4).longValue() == distance.get(5).longValue())
                result.add("YES");
            else
                result.add("NO");
        }
        for(String s : result){
            System.out.println(s);
        }
    }
}
