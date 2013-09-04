package org.teaserver.persistence

import java.util.Properties
import java.sql.{Connection, DriverManager}
import Class.forName

trait DBConnection {
  def getConnection(props:Properties) : Connection = {
    forName(props.getProperty("org.teaserver.classname"))
    DriverManager.getConnection(props.getProperty("org.teaserver.url"), props.getProperty("org.teaserver.user"), props.getProperty("org.teaserver.pass") )
  }
}
