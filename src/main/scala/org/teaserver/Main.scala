package org.teaserver

import org.eclipse.jetty.server.Server
import com.typesafe.config.{ConfigValue, ConfigFactory}
import org.teaserver.interceptor.InterceptorFactory

object Main {
  def main(args: Array[String]) {
    val config = ConfigFactory.load
    val interceptors = for (i: ConfigValue <- config.getList("org.teaserver.interceptor")) yield {
      val obj = Class.forName(i.unwrapped().toString).newInstance
      obj.asInstanceOf[InterceptorFactory].createInterceptor(config)
    }

    val server = new Server(8080);
    server.setHandler(new RequestHandler(interceptors));
    server.start;
    server.join;
  }
}
