//package programmers;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//class Solution {
//    public int solution(String[] user_id, String[] banned_id) {
//        int answer = 0;
//        Set<String>[] nameSet = new Set[];
//        for (int i = 0; i < nameSet.length; i++) {
//            nameSet[i] = new HashSet<>();
//        }
//        for (int i = 0; i < banned_id.length; i++) {
//            for (int j = 0; j < user_id.length; j++) {
//                boolean confirm = false;
//                for (int k = 0; k < user_id[j].length(); k++) {
//                    if(user_id[j].charAt(k) == '*') {
//
//                    }
//                }
//            }
//        }
//        return answer;
//    }
//
//    Long findMax(int[] arr, int n) {
//        List<Long> partSum = new ArrayList<>();
//        int part = arr[0];
//        boolean confirm = part >= 0 ? true : false;
//
//        long max = 0;
//        int index = 0;
//        for(int i=1; i<arr.length; i++) {
//            if(arr[i] == 0 || arr[i] > 0 == confirm) {
//                part += arr[i];
//
//            }else {
//                partSum.add(part);
//                if(part > max) {
//                    max = part;
//                    index = partSum.size()-1;
//                }
//                part = arr[i];
//                confirm = !confirm;
//            }
//
//            if(i == n-1) {
//                partSum.add(part);
//                if(part > max) {
//                    max = part;
//                    index = partSum.size()-1;
//                }
//            }
//        }
//
//        long count = 0;
//        for(int i=index-1; i>=0; i--) {
//            count += partSum.get(i);
//            if(count > 0) {
//                max += count;
//                count = 0;
//            }
//        }
//
//        count = 0;
//        for(int i=index+1; i<partSum.size(); i++) {
//            count += partSum.get(i);
//            if(count > 0) {
//                max += count;
//                count = 0;
//            }
//        }
//
//        return max;
//    }
//}
