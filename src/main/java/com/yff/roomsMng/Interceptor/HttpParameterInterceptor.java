package com.yff.roomsMng.Interceptor;

import com.github.pagehelper.Page;
import org.jboss.logging.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将response转换成datatable所需要的json数据格式
 *
 * @author jacarri
 *
 */
public class HttpParameterInterceptor extends HandlerInterceptorAdapter {

   /* private Integer pagecount;// 页码
    private Integer pagerow = 10;// 每页显示行数
    private Logger logger = Logger.getLogger(HttpParameterInterceptor.class);
    // before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getParameter("rows") != null) {
            Integer rows = Integer.parseInt(request.getParameter("rows"));
            if (rows != 0 || rows != null) {
                logger.debug("重新赋值每页显示行数");
                pagerow = rows;
            }
            return true;
        }
        return true;

    }


    // after the handler is executed
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (null != modelAndView && null != modelAndView.getModel()) {
            Object result = modelAndView.getModel().get("result");
            // 取出page对象，拿出datatable所需要的一些参数
            if (null != result && result instanceof Page) {
                logger.warn("正在重整json的result属性........................");
                Page page = (Page) result;
                pagecount = (page.getTotal() - 1) / pagerow + 1;
                logger.warn("正在重整json的result属性........................" + page.getTotal() + "----" + pagerow);
                modelAndView.addObject("pagecount", pagecount);
                // 页面上显示总条数需要的
                // modelAndView.addObject("iTotalRecords", page.getRows());
                modelAndView.addObject("iTotalDisplayRecords", page.getTotal());
                // 将整个json数据改成datatable插件所需要的样子:{[list],iTotalRecords:1,iTotalDisplayRecords:2}
                modelAndView.addObject("result", page.getResult());
            }
        }
        String sEcho = (String) request.getParameter("sEcho");
        // modified the exisitng modelAndView
        if (null != modelAndView && null != sEcho) {
            // 添加datatable插件需要的sEcho
            modelAndView.addObject("sEcho", sEcho);
        }
    }*/
}