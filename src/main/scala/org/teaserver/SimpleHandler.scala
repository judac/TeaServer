package org.teaserver

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import scala.util.parsing.json.JSONObject

class SimpleHandler extends AbstractHandler{
  def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
    response.setContentType("text/html;charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    baseRequest.setHandled(true)
    import response.{getWriter=> w}

    val test = Map ("oi"-> "oi", "opa"->"hihi")
    val obj = new JSONObject(test)
    w.write(obj.toString())
  }
}
