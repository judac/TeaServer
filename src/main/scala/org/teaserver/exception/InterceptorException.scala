package org.teaserver.exception

/**
 * Created by augusto on 22/02/14.
 */
class InterceptorException (result: Map[String, Any]) extends RuntimeException("Interception Exception") {

  def response = result
}
