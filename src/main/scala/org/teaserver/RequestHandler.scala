package org.teaserver

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.teaserver.interceptor.TeaInterceptor
import org.teaserver.plugin.TeaPlugin

class RequestHandler(interceptors: List[TeaInterceptor], plugins: List[TeaPlugin]) extends AbstractHandler {
  def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
    response.setContentType("text/html;charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    baseRequest.setHandled(true)
  }
}
