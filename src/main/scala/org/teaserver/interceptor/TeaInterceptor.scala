package org.teaserver.interceptor

import javax.servlet.http.{HttpSession, HttpServletRequest}
import com.typesafe.config.Config

trait InterceptorFactory {
  def createInterceptor(config: Config): TeaInterceptor
}

trait TeaInterceptor {
  def intercept(parameters: Map[String, Array[String]], request: HttpServletRequest, session: HttpSession)
}
