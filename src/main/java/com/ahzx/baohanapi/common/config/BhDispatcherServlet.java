package com.ahzx.baohanapi.common.config;

import com.ahzx.baohanapi.common.Interceptor.RequestWrapper;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author Joy
* @summary 自定义 DispatcherServlet 来分派 RequestWrapper
*/
public class BhDispatcherServlet extends DispatcherServlet {

  /**
   * 包装成我们自定义的request
   * @param request
   * @param response
   * @throws Exception
   */
  @Override
  protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    super.doDispatch(new RequestWrapper(request), response);
  }
}
