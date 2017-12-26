package controller;


import domain.ImgView;
import domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {


    private static final String BASE_PATH = "D:\\mzitu";

    @RequestMapping("listPage")
    @ResponseBody
    public Object getListPage(Page page){
        return getDirList(page);
    }


    private Map<String,Object> getDirList(Page page) {
        File file = new File(BASE_PATH);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数：" + tempList.length);
        Map<String,Object> resultMap = new HashMap<String,Object>();


        List<ImgView> views = new ArrayList<ImgView>();

        int startIndex = 0,endIndex=  0;

        if(page.getStartNo()< tempList.length){
            startIndex = page.getStartNo();
        }

        if(page.getStartNo()+page.getLength() >= tempList.length){
            endIndex = tempList.length;
        }else{
            endIndex = page.getStartNo()+page.getLength();
        }


        for (int i = startIndex; i < endIndex; i++) {
            File f = tempList[i];
            ImgView view = new ImgView();
            view.setTitle(f.getName());
            view = getDirDeatil(view,f.getPath());
            views.add(view);
        }

        resultMap.put("resultData",views);
        resultMap.put("page",new Page(page.getPageNo(),tempList.length));
        return resultMap;
    }

    private ImgView getDirDeatil(ImgView view , String path){
        File file = new File(path);
        File[] tempList = file.listFiles();

        if(null == tempList || tempList.length ==0){
            return view;
        }
        view.setIndexImg(filterImgPath(tempList[0].getPath()));


        List<String> childImgs = new ArrayList<String>();
        for (int i = 0; i < tempList.length; i++) {
            File f = tempList[i];
            childImgs.add(filterImgPath(f.getPath()));
        }
        view.setChildImgs(childImgs);
        return view;
    }

    private String filterImgPath(String path){
        return path.replace("D:","");
    }


}
