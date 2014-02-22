package org.teaserver.plugin

import com.typesafe.config.Config

trait PluginFactory {
  def create(config: Config): TeaPlugin
}

trait TeaPlugin {
  def name: String

  def execute(parameters: Map[String, Array[String]]): Map[String, Any]
}
