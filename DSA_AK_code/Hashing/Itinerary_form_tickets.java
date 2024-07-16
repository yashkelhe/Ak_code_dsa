package Hashing;

import java.util.*;

public class Itinerary_form_tickets {

    public static String  getStart(HashMap<String, String> tickets ){
        HashMap<String, String> reMap = new HashMap<>();
        // here we will store as as value and  key  
        for(String key : tickets.keySet()){
            reMap.put(tickets.get(key), key);
        }

        // now here we will  comapre that the tcikets if containes the key and reMap does not the that will be the  starting key 
        for( String key :  tickets.keySet()){
            if(!reMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<String, String>();

        tickets.put("C", "B");
        tickets.put("M", "D");
        tickets.put("G", "C");
        tickets.put("D", "G");

        String start = getStart(tickets);
        System.out.print(start);

        for(String key : tickets.keySet()){
            System.out.print("->"+ tickets.get(start));
                // here value will be assign to the start so the next start should start and will give me hole journey
            start = tickets.get(start);
        }   

    System.out.println();

    }
}