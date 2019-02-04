package com.staroot.mybatis.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staroot.mybatis.controller.UserController;
import com.staroot.mybatis.domain.User;
import com.staroot.mybatis.web.HttpSessionUtil;

import java.io.IOException;
  
@Component
public class LoginCheckFilter implements Filter {
	  public static final String X_HEADER_TEST = "X_HEADER_TEST";
	  
	  private Logger logger = LoggerFactory.getLogger(this.getClass());
	  
	  @Override
	  public void doFilter(ServletRequest req, ServletResponse res,
	      FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;

			String requestURI = request.getRequestURI();
			

			//security area session check
			if(
					//HOME (index)
					//=====================================================================
					requestURI.equals("/") ||
					//=====================================================================

					//TEST
					//=====================================================================
					requestURI.startsWith("/test/test1") ||
					requestURI.startsWith("/test/test2") ||
					//=====================================================================

					//SWAGGER
					//=====================================================================
					requestURI.startsWith("/swagger") ||
					requestURI.startsWith("/swagger-ui.html") ||
					requestURI.startsWith("/swagger-resources/configuration/ui") ||
					requestURI.startsWith("/swagger-resources") ||
					requestURI.startsWith("/v2/api-docs") ||
					//=====================================================================
					
					
					//ETC
					//=====================================================================
					requestURI.startsWith("/api/users") ||
					requestURI.startsWith("/user/login") ||
					requestURI.startsWith("/user/register") ||
					requestURI.startsWith("/images") ||
					requestURI.startsWith("/js") ||
					requestURI.startsWith("/h2") ||
					requestURI.startsWith("/webjars") ||
					requestURI.startsWith("/board/list")
					//=====================================================================
					){
				//DO NOT LoginCheck
	    	        logger.debug("==============================================================");
			    logger.debug("Login check ignored::"+request.getRequestURI());
	    	        logger.debug("==============================================================");
			    chain.doFilter(req, res);
			}else{
			    HttpSession session = request.getSession(false);
			    if(session != null){
				    User user = HttpSessionUtil.getUserFromSession(session);
				    if(user != null){
			    	        logger.debug("==============================================================");
				    	    logger.debug("Login required!::"+request.getRequestURI());
					    logger.debug("Login User ::"+user.toString());
					    logger.debug("111111111111111111111111");
						chain.doFilter(req, res);
      				    logger.debug("222222222222222222222222");
			    	        logger.debug("==============================================================");
				    }else{
 			    	        logger.debug("==============================================================");
				    		logger.debug("Login required!::"+request.getRequestURI());
				    		logger.debug("Session exists! But Not Logined yet!");
				    	    logger.debug("==============================================================");
				    	    response.sendRedirect("/user/login");
				    }
			    }else{
			    	    logger.debug("==============================================================");
			    	    logger.debug("Login requred!::"+request.getRequestURI());
			    	    logger.debug("Session doesn't exists! And Not Logined yet!");
  		    	        logger.debug("==============================================================");
			    		response.sendRedirect("/user/login");
			    }
			}
	  }

	  @Override
	  public void destroy() {
		  logger.debug(":::TestFilter destroy() called");
	  }

	  @Override
	  public void init(FilterConfig arg0) throws ServletException {
		  logger.debug(":::TestFilter init() called");		  
	  }
}
