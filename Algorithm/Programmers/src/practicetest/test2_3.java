package practicetest;

import java.util.HashSet;

public class test2_3 {
    static int[] check;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];


        Location[] locations = new Location[n + 1];
        for (int i = 1; i <= n; i++) locations[i] = new Location(i);

        for (int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][0];
            locations[start].connectRoad(locations[end]);
        }

        for (int i = 0; i < sources.length; i++) {
            Location startLocation = locations[sources[i]];
            int count = 0;
            if(startLocation.number != destination) {
                check = new int[n + 1];
                count = startLocation.findDestination(0, n, destination);
            }
            answer[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return answer;
    }


    class Location {
        int number;
        HashSet<Location> connectSet;

        public Location(int number) {
            this.number = number;
            this.connectSet = new HashSet<>();
        }

        public void connectRoad(Location location){
            this.connectSet.add(location);
            location.connectSet.add(this);
        }

        public int findDestination(int L, int n, int destination) {
            if(L > n) return Integer.MAX_VALUE;
            if(number == destination) return L;
            else {
                L ++;
                int temp = Integer.MAX_VALUE;
                for (Location location: connectSet) {
                    if(check[location.number] == 0)
                        check[location.number] = 1;
                        temp = Math.min(temp, location.findDestination(L + 1, n, destination));
                        check[location.number] = 0;
                }
                return temp;
            }
        }
    }

}
