package src.main.java;

import java.util.*;

public class LeetCode_1366_Rank_Teams_By_Votes {
    public String rankTeams(String[] votes) {
        int numOfTeams = votes[0].length();
        String rank = "";

        Map<Character, Integer[]> summary = new HashMap<>();

        for (int i = 0; i < numOfTeams; i++) {
            for (int j = 0; j < votes.length; j++) {
                Character c= votes[j].charAt(i);

                if (!summary.containsKey(c)) {
                    Integer[] rankCount = new Integer[numOfTeams];
                    for (int m = 0; m < numOfTeams; m++) {
                        rankCount[m] = 0;
                    }

                    rankCount[i] = 1;

                    summary.put(c, rankCount);
                } else {
                    summary.get(c)[i] += 1;
                }
            }
        }

        Set<Map.Entry<Character, Integer[]>> set = summary.entrySet();

        List<Map.Entry<Character, Integer[]>> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer[]>>() {
            @Override
            public int compare(Map.Entry<Character, Integer[]> o1, Map.Entry<Character, Integer[]> o2) {
                //return 0;
                for (int i = 0; i < numOfTeams;i++) {
                    if (o1.getValue()[i] > o2.getValue()[i]) {
                        return 1;
                    }

                    if (o1.getValue()[i] < o2.getValue()[i]) {
                        return -1;
                    }
                }

                return o1.getKey() < o2.getKey() ? 1 : -1;
            }
        });

        return generateRank(list);
    }

    private String generateRank(List<Map.Entry<Character, Integer[]>> list) {
        String result = "";
        for (Map.Entry entry: list) {
            result = entry.getKey().toString() + result;
        }

        return result;
    }
}
