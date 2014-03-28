package org.teaserver

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.teaserver.interceptor.TeaInterceptor
import org.teaserver.plugin.TeaPlugin
import scala.util.parsing.json.{JSON, JSONObject}
import java.util.NoSuchElementException
import scala.collection.JavaConverters._
import org.teaserver.exception.InterceptorException

class RequestHandler(interceptors: List[TeaInterceptor], plugins: Map[String, TeaPlugin]) extends AbstractHandler {

  def handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {

    response.setContentType("text/html;charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    baseRequest.setHandled(true)
    import response.{getWriter => w}
    try {
      interceptors.foreach(i => {
        i.intercept(baseRequest.getParameterMap.asScala.toMap, request, request.getSession)
      })
      val plugin = baseRequest.getParameter("plugin")
      val theRequest = (JSON parseFull baseRequest.getParameter("parameter")).get.asInstanceOf[Map[String, Any]]
      val result = plugins(plugin).execute(theRequest)
      val resultJson = new JSONObject(result)
      w write resultJson.toString
    } catch {
      case e: InterceptorException => {
        val result = Map("result" -> "error", "response" -> e.response)
        val resultJson = new JSONObject(result)
        w write resultJson.toString
      }
      case e: NoSuchElementException => {
        val result = Map("result" -> "error", "message" -> "Plugin not found")
        val resultJson = new JSONObject(result)
        w write resultJson.toString
      }
      case e => {
        val result = Map("result" -> "error", "message" -> e.getMessage)
        val resultJson = new JSONObject(result)
        w write resultJson.toString
      }
    }
  }
}
