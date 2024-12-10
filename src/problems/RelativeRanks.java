package problems;

public class RelativeRanks {

    public static void main(String[] args) {
        findRelativeRanks(new int[]{5,4,3,2,1});
    }
    public static String[] findRelativeRanks(int[] score) {
        /*int n = score.length;
        int[][] sindex = new int[n][2];

        for (int i = 0; i < n; i++) {
            sindex[i] = new int[] { score[i], i };
        }

        Arrays.sort(sindex, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int index = sindex[i][1];
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;*/

        int len = score.length;
        int max = max(score);
        String[] result = new String[len];
        int[] scoreIndex = new int[max + 1];
        for(int i = 0; i < len; i++){
            scoreIndex[score[i]] = i + 1;
        }
        int place = 1;
        String[] prize = {"Gold Medal","Silver Medal","Bronze Medal"};
        for(int i = max; i >= 0; i--){
            if(scoreIndex[i] != 0){
                int org = scoreIndex[i] - 1;
                if(place < 4){
                    result[org] = prize[place - 1];
                }else{
                    result[org] = String.valueOf(place);
                }
            }

        }

        return result;
    }

    public static int max(int[] nums){
        int max = 0;
        for(int i : nums){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
