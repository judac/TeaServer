package org.teaserver

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import scala.util.parsing.json.{JSON, JSONObject}

class SimpleHandler extends AbstractHandler {
  def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
    response.setContentType("text/html;charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    baseRequest.setHandled(true)

    import response.{getWriter => w}
    try
      val action = baseRequest.getParameter("action")
      val theRequest = new JSONObject((JSON parseFull baseRequest.getParameter("parameters")).get.asInstanceOf[Map[String, Any]])
      val result = Map("result" -> "success")
      val resultJson = new JSONObject(result)
      w write resultJson.toString
    catch {
      case e => {
        val result = Map("result" -> "error", "message" -> e.getMessage)
        val resultJson = new JSONObject(result)
        w write resultJson.toString
      }
    }
  }
}
