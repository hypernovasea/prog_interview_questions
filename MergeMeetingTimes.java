import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeMeetingTimes {

	public static void main(String[] args) {
		List<Meeting> meetings = new ArrayList<Meeting>();

		meetings.add( new Meeting(0, 1) );
		meetings.add( new Meeting(3, 5) );
		meetings.add( new Meeting(4, 8) );
		meetings.add( new Meeting(10, 12) );
		meetings.add( new Meeting(9, 10) );

		meetings = mergeRanges(meetings);
		for(Meeting m : meetings){
			System.out.println(m.toString());
		}

	}


	public static List<Meeting> mergeRanges(List<Meeting> meetings) {

	    // sort by start times
	    List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);

	    Collections.sort(sortedMeetings, new Comparator<Meeting>() {
	        public int compare(Meeting m1, Meeting m2)  {
	            return m1.startTime - m2.startTime;
	        }
	    });

	    // initialize mergedMeetings with the earliest meeting
	    List<Meeting> mergedMeetings = new ArrayList<Meeting>();
	    mergedMeetings.add(sortedMeetings.get(0));

	    for (Meeting currentMeeting : sortedMeetings) {

	        Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

	        // if the current and last meetings overlap, use the latest end time
	        if (currentMeeting.startTime <= lastMergedMeeting.endTime) {
	            lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);

	        // add the current meeting since it doesn't overlap
	        } else {
	            mergedMeetings.add(currentMeeting);
	        }
	    }

	    return mergedMeetings;
	}



	public static class Meeting {

	    int startTime;
	    int endTime;

	    public Meeting(int startTime, int endTime) {
	        // number of 30 min blocks past 9:00 am
	        this.startTime = startTime;
	        this.endTime   = endTime;
	    }

	    public String toString() {
	        return String.format("(%d, %d)", startTime, endTime);
	    }
	}

}
