package com.github;
/*
  support that a coffee shop send free coupon to randomly selected customer everyday
 */
public class LeftInterval {

  public static int solution(int[] playList, int listenTime){
    //check if listTime >= total song time
    int listenTimeRemain = listenTime;
    for (int songTime : playList) {
      listenTimeRemain -= songTime;
    }
    if (listenTimeRemain > -1) {
      return playList.length;
    }

    int maxPlayIndex = playList.length - 1;
    int maxSong = 1;
    for (int i = 0; i < playList.length; i++) {
      int remain = listenTime;
      //listen first song 1 minus always the best
      remain = remain - 1;
      int numSong = 1;

      while (remain > 0) {
        remain = remain - playList[nextIndex(i, maxPlayIndex)];
        numSong++;
      }
      if (numSong >= playList.length) {
        return playList.length;
      }

      if (numSong > maxSong) {
        maxSong = numSong;
      }

    }
    return maxSong;
  }

  private static int nextIndex(int i, int max) {
    if (++i > max) {
      i = 0;
    }
    return i;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{2,3,1,4}, 3));
    System.out.println(solution(new int[]{1,2,3,4}, 5));
    System.out.println(solution(new int[]{1,2,3,4}, 20));
    System.out.println(solution(new int[]{1,2,3,4,5}, 30));
    System.out.println(solution(new int[]{2,1,5,9,8,1,1,1,8}, 4));
  }


}
