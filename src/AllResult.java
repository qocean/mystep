import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AllResult {

    public List<List<Integer>> getAllPosibility(int[][] allArray){
        int arrayNum = allArray.length;
        List<List<Integer>> resultList = new LinkedList<>();

        for(int n=0 ; n<allArray[0].length ; n++){
            List<Integer> initList = new ArrayList<>();
            initList.add(allArray[0][n]);
            resultList.add(initList);
        }

        for(int i = 1 ; i < arrayNum ; i++){
            int arrayLength = allArray[i].length;
            List<List<Integer>> tempResultList = new ArrayList<>();
            for(List<Integer> existList : resultList) {
                for (int j = 0; j < arrayLength; j++){
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(existList);
                    newList.add(allArray[i][j]);
                    tempResultList.add(newList);
                }
            }
            resultList.clear();
            resultList.addAll(tempResultList);
        }
        return resultList;
    }

    public boolean isBad(int a){
        if(a >=3) return true;
        else{
            return false;
        }
    }

    int findFirstBad(int arr[]){
        int length = arr.length;
        int head = 0 , tole = length - 1 ,mid = (head+tole)/2;
        while(head <= tole){
            if(isBad(arr[mid]) == true){
                if(isBad(arr[mid-1]) == false) return mid;
                tole = mid-1;
            }else{

                head = mid+1;
            }
            mid = (head+tole)/2;
        }
        return -1;
    }



    public static void main(String[] args){
        Integer integer = 1;
        Thread thread1 = new Thread(new MyThread(1));
        Thread thread2 = new Thread(new MyThread(2));
        thread1.start();
        thread2.start();
    }
}
class MyThread implements Runnable{

    private Integer integer;
    public MyThread(Integer integer){
        this.integer = integer;
    }

    @Override
    public void run() {
        synchronized (integer){
            while(true){
                integer.notify();
                System.out.println(integer++);
                try {
                    integer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}