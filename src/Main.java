import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Solution {

	private static Scanner scanner;

	public static void main(String[] argh) {
		scanner = new Scanner(System.in);
		int numberOfDestinations = scanner.nextInt();
		Map<String, Integer> destinationsOccurrencesMap = new HashMap<String, Integer>();
		String destination;
		Integer numberOfOcurrences;
		for (int i = 0; i < numberOfDestinations; i++) {
			destination = scanner.next();
			numberOfOcurrences = destinationsOccurrencesMap.get(destination);
			if(numberOfOcurrences == null){
				destinationsOccurrencesMap.put(destination, 1);
			}else{
				destinationsOccurrencesMap.put(destination, numberOfOcurrences+1);
			}
		}
		Set<Entry<String, Integer>> entrySet = destinationsOccurrencesMap.entrySet();
		List<Entry<String, Integer>> myEntrySetList = new ArrayList<>();
		myEntrySetList.addAll(entrySet);
		Collections.sort(myEntrySetList, new Comparator<Entry<String, Integer>>() {
		    public int compare(Entry<String, Integer> pair1, Entry<String, Integer> pair2) {
		    	return pair2.getValue().compareTo(pair1.getValue());
		    }
     	});
		System.out.println(myEntrySetList.get(0).getKey());
	}
}

class MyPair{
	private String destination;
	private Integer occurrences;
	
	public MyPair(String destination, int occurrences) {
		this.destination = destination;
		this.occurrences = occurrences;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getOccurrences() {
		return occurrences;
	}
	public void setOccurrences(Integer occurrences) {
		this.occurrences = occurrences;
	}
}