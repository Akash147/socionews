/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newsrecommendation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ravi
 * @param <T>
 */
public class Combination<T> {
  private final List<T> originalList;
  List<T> combinations;
  public Combination(List<T> originalList) {
    this.originalList = originalList;
  }
 
  
  public List<T> getComb(){
      List<T> comb = new ArrayList<>();
//      System.out.println(this.originalList);
      for (int i=0; i<this.originalList.size(); i++){
          for (int j=i+1; j<this.originalList.size(); j++){
               T s = (T) (this.originalList.get(i) + " " + this.originalList.get(j));
               comb.add(s);
//               System.out.println(s);
          }
          
      }
      
      return comb;
  }
  public List<T> getCombAllWords(){
      List<T> allWordsComb = new ArrayList<>();
      for(int i=0;i<this.originalList.size()-1;i++){
          T jpt =(T) (this.originalList.get(i) + " "+ this.originalList.get(i+1));
          allWordsComb.add(jpt);
      }
      return allWordsComb;
  } 
}
