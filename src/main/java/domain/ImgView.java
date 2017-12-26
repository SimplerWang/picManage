package domain;

import java.io.Serializable;
import java.util.List;

/**
 * 页面视图
 */
public class ImgView implements Serializable {

    String title;

    String indexImg;

    List<String> childImgs;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndexImg() {
        return indexImg;
    }

    public void setIndexImg(String indexImg) {
        this.indexImg = indexImg;
    }

    public List<String> getChildImgs() {
        return childImgs;
    }

    public void setChildImgs(List<String> childImgs) {
        this.childImgs = childImgs;
    }
}
