package my.project.library.utill.validators;

import org.springframework.ui.Model;

public class ForPages {
    public static int checkAndSaveValuesForPagination(int page, int size, long quantity, Model model){
        if(page<=0) page = 1;
        if(quantity<=0) quantity = 1;
        if(size<0) size = 5;


        int maxPage =(int) (((quantity)/size) - (quantity%size==0?1:0))+1;
        System.out.println(quantity + " " + size + " " + maxPage + " " + page);
        page = Math.min(maxPage, page);

        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("size", size);

        return page-1;
    }
}
