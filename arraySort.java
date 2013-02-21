/**Given an array of integers, 
 * write some code to find all the integers that appear more than once in the array, 
 * sorted by which appears most often to least often (once)
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;



class arraySort {
  public static void main(String[] args){
		int array[] = {1,1,1,1,46,46,35,57,1,68,23,68,68,68,136,35};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> outputMap = new HashMap<Integer, Integer>();
		int i;
		for(i = 0; i < array.length; i++) {
			int number = array[i];
			Integer freq = map.get(number);
			if (freq == null) {
				map.put(number, 1);
			}
			else {
				map.put(number, freq + 1);
				outputMap.put(number, freq + 1);
			}
		}
		sortByValue(outputMap);
	
	}
	public static void sortByValue(Map<Integer, Integer> map) {
		List<Map.Entry> list = new ArrayList<Map.Entry>(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o2, Object o1) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				return ((Comparable) e1.getValue()).compareTo(e2.getValue());
				
			}
		});
		for (Map.Entry e : list) {
			System.out.println(e.getKey() + " appears " + e.getValue() + " times");
		}
    }
	
	
}

