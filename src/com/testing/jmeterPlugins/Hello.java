package com.testing.jmeterPlugins;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Hello extends AbstractJavaSamplerClient {
	public String uname="";	
	//定义GUI界面的参数
	@Override
	public Arguments getDefaultParameters() {
		Arguments param=new Arguments();
		param.addArgument("username", "请输入您的用户名");
		return param;
	}
	
	@Override
	public void setupTest(JavaSamplerContext context) {
		uname=context.getParameter("username");
	}
	//主体执行部分

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
//		//接收用户通过username所传递过来的值
//		String username=arg0.getParameter("username");
		//new一个sampleResult对象，用来实现计时、结果回写等操作
		SampleResult sr=new SampleResult();
		//请求开始计时
		sr.sampleStart();
		//业务操作
		sr.setResponseData(uname+"，hello,欢迎学习jmeter二次开发",SampleResult.TEXT);
		//设置请求的结束状态
		sr.setSuccessful(true);
		//请求结束计时
		sr.sampleEnd();
		return sr;
	}

}
