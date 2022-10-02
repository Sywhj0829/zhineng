package com.ncyteng.zhineng.tools;



import com.ncyteng.zhineng.exception.BusinessErrorException;
import com.ncyteng.zhineng.exception.BusinessMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;

//实现HandlerInterceptor接口  接口主要作用就是拦截器的作用
//定义拦截器
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();

//       设置session
        HttpSession session = request.getSession();
        if (session.getAttribute("id")==null){//判断session是否为空
//如果空就执行跳转。
 //            抛出异常  BusinessErrorException 设置的异常类 BusinessMsgEnum枚举类
            throw new BusinessErrorException(BusinessMsgEnum.SESSION_EMPTY);
        }


        //获取token
//        从ajax里面的heards属性获取
//        String token = request.getHeader("token");
//        if(!StringUtils.hasLength(token)){
////            从ajax里面的data属性获取
//            token = request.getParameter("token");
//        }
//        if(!StringUtils.hasLength(token)){
////            抛出异常  BusinessErrorException 设置的异常类 BusinessMsgEnum枚举类
//            throw new BusinessErrorException(BusinessMsgEnum.JWT_EMPTY);
//        }


// 返回true才会继续执行，返回false则取消当前请求
        return true;
    }
}
