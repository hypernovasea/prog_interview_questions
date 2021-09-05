package src.medium;

import java.util.*;

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> mergedIntervals = new LinkedList<Interval>();

        // sort intervals by start time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return Integer.compare(i.start, j.start); 
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (int i=1; i<intervals.size(); i++) {
            Interval x = intervals.get(i);
            
            // overlapping intervals --> merge them
            if (end >= x.start) {
                end = Math.max(end, x.end);
            } 
            else { // no overlap
                mergedIntervals.add(new Interval(start, end));
                start = x.start;
                end = x.end;
            }
        }

        // add last interval
        mergedIntervals.add(new Interval(start, end));

        //iterate thru intervals
        return mergedIntervals;
    }
    
}