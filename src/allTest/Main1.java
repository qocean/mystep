package allTest;

import java.util.*;
import java.util.regex.Pattern;

class Car{
    int joinTime;
    int leaveTime;
}

public class Main1 {
    private static final String carSplit =";";
    private static final String timeSplit =",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";

    public static void main(String[] args) {
        String inString = null;
        // 数据输入
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //字符串数组格式校验
        Pattern pat = Pattern.compile(regress);
        if(inString == null || inString.trim().equals("")||!pat.matcher(inString).matches()){
            System.out.println("输入错误!");
            return;
        }
        Main1 sol = new Main1();
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // 字符转数组判断
        int[][] carArray = new int[row][col];
        int start,end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if(start>end){
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }

    public int countCars(int[][] carArray) {
        int ans = 0;
        List<Car> sortByJoinTime = new ArrayList<>();
        LinkedList<Car> sortByLeaveTime = new LinkedList<>();
        int n=carArray.length;
        for(int i=0; i<n ; i++){
            if(carArray[i][0] > carArray[i][1]) continue;
            Car car = new Car();
            car.joinTime = carArray[i][0];
            car.leaveTime = carArray[i][1];
            sortByJoinTime.add(car);
            sortByLeaveTime.add(car);
        }

        Collections.sort(sortByJoinTime, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.joinTime - o2.joinTime;
            }
        });

        Collections.sort(sortByLeaveTime, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.leaveTime-o2.leaveTime;
            }
        });


        for(Car car : sortByJoinTime){
            while(!sortByLeaveTime.isEmpty() && car.joinTime > sortByLeaveTime.getFirst().leaveTime ){
                sortByLeaveTime.removeFirst();
            }
            ans = Math.max(ans,sortByLeaveTime.size()-1);

        }

        return ans; // 返回计算结果
    }
}
