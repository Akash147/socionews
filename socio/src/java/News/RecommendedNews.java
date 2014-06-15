/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package News;

import java.util.List;

/**
 *
 * @author noones
 */
public class RecommendedNews extends DisplayNews{
    private List recommendedNews;
    
    public RecommendedNews(){
        
    }

    public List getRecommendedNews() {
        return recommendedNews;
    }

    public void setRecommendedNews(List recommendedNews) {
        this.recommendedNews = recommendedNews;
    }
    
    
}

