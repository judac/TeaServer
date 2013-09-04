name := "TeaServer"

version := "0.1"

scalaVersion := "2.10.1"

classpathTypes += "orbit"

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

libraryDependencies += "org.mongodb" %% "casbah" % "2.6.2"

libraryDependencies += "org.eclipse.jetty" % "jetty-server" % "9.0.0.RC2"

ivyXML :=
<dependency org="org.eclipse.jetty.orbit" name="javax.servlet" rev="3.0.0.v201112011016">
<artifact name="javax.servlet" type="orbit" ext="jar"/>
</dependency>