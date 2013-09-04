package org.teaserver

import org.eclipse.jetty.server.Server

object Main {
  def main(args:Array[String]){
    val server = new Server(8080);
    server.setHandler(new SimpleHandler);
    server.start;
    server.join;
  }
}
