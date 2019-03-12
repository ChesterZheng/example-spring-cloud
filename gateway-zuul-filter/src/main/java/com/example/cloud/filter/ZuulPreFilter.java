package com.example.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulPreFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulPreFilter.class);

	/**
	 * 表示是否使用此过滤器
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器中的具体逻辑
	 */
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String remoteHost = request.getRemoteHost();
		LOGGER.info("请求的Host是 = " + remoteHost);
		return null;
	}

	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行的顺序
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}
