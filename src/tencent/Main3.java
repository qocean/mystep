package tencent;

import java.util.*;

class Job{
    int jobTime;
    int jobLevel;
    int profit;
}

class Machine{
    int machineTime;
    int machineLevel;
    List<Job> couldDoJob = new ArrayList<>();
}

public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Machine[] machines = new Machine[n];
        Job[] jobs = new Job[m];

        for(int i=0 ; i<n ; i++){
            Machine machine = new Machine();
            machine.machineTime = sc.nextInt();
            machine.machineLevel = sc.nextInt();
            machines[i] = machine;
        }
        for(int i=0; i<m ; i++){
            Job job = new Job();
            job.jobTime = sc.nextInt();
            job.jobLevel = sc.nextInt();
            job.profit = job.jobTime*200 + job.jobLevel*3;
            jobs[i] = job;
            for(Machine machine : machines){
                if(job.jobTime <= machine.machineTime && job.jobLevel<= machine.machineLevel)
                    machine.couldDoJob.add(job);
            }
        }

        for(Machine machine : machines){
            Collections.sort(machine.couldDoJob, new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o2.profit-o1.profit;
                }
            });
        }
        HashSet<Job> hasDoneJob = new HashSet<>();
        int numOfJob = 0;
        int maxProfit = 0;
        int nowMax = 0 , nowProfilt = 0;
        for(Machine machine : machines){
            for(Job job : machine.couldDoJob){
                if(hasDoneJob.contains(job)) continue;
                nowProfilt += job.profit;
                nowMax++;
                hasDoneJob.add(job);
                break;
            }
        }
        System.out.println(nowMax + " " + nowProfilt);

    }

    public static void getProfilt(Machine[] machines ){
        int numOfJob = 0;
        int maxProfit = 0;
        int nowMax = 0 , nowProfilt = 0;
        HashSet<Job> hasDoneJob = new HashSet<>();
        for(Machine machine : machines){
            for(Job job : machine.couldDoJob){
                if(hasDoneJob.contains(job)) continue;
                nowProfilt += job.profit;
                nowMax++;
                break;
            }
        }
    }
}
