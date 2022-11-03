package cn.stylefeng.guns.modular.demo.controller.view.scy;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List page(Integer limit, Integer page, List list){
        if (limit == null || page == null||limit<=0||page<0) {
            return list;
        }
        if (list == null || list.size() == 0) {
            return list;
        }
        int start = (page - 1) * limit;
        int end = page * limit;
        if(start>list.size()){
            return new ArrayList<Object>();
        }else if(end>list.size()){
            return list.subList(start, list.size());
        }
        return list.subList(start, end);
    }
}
