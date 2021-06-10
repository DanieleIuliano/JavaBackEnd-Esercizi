package Modulo4_EsercizioLeetCodeShuffleArray;

import java.util.Arrays;
import java.util.Random;

/*
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */
public class Solution {

    int [] soluzione;
    final int [] soluzioneIniziale;

    public Solution(int[] nums ) {
        soluzione = nums;
        soluzioneIniziale = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.out.println(Arrays.toString(soluzioneIniziale));
        return soluzioneIniziale;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        Random random = new Random();
        int posizioneRandom;
        int i = 0;
        int[] shuffleArray = new int[soluzione.length];

        while(i < soluzione.length){

            posizioneRandom = random.nextInt(soluzione.length);

            if(shuffleArray[posizioneRandom] == 0){

                shuffleArray[posizioneRandom] = soluzione[i];
                i++;
            }

            continue;


        }

        soluzione = shuffleArray;

        return soluzione;

    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++){
            int temp = 0;
            if(i < k){
                temp = nums[i];
                nums[i] = nums[i+k];
                nums[i+k] = temp;
            }else {
                 
            }
        }
    }
}
